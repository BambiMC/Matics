import {
  useLang,
  useLanguageData,
  getLanguageData,
} from "@data/languageLoader";

const TOLERANCE = 128;

export function floodBackground(canvas: HTMLCanvasElement) {
  if (!canvas) return;
  const tolerance = TOLERANCE;

  const corners: [number, number][] = [
    [0, 0],
    [canvas.width - 1, 0],
    [0, canvas.height - 1],
    [canvas.width - 1, canvas.height - 1],
  ];

  for (const corner of corners) {
    setBackgroundBlack(canvas, tolerance, corner);
  }
}

export function setBackgroundBlack(
  canvas: HTMLCanvasElement,
  tolerance: number,
  startPixel: [number, number]
) {
  const ctx = canvas.getContext("2d");
  if (!ctx) return;

  const width = canvas.width;
  const height = canvas.height;

  const imageData = ctx.getImageData(0, 0, width, height);
  const data = imageData.data;

  const getPixelIndex = (x: number, y: number) => (y * width + x) * 4;

  const visited = new Uint8Array(width * height);
  const stack: [number, number][] = [startPixel];

  const [sx, sy] = startPixel;
  const startIdx = getPixelIndex(sx, sy);

  const r0 = data[startIdx];
  const g0 = data[startIdx + 1];
  const b0 = data[startIdx + 2];

  const colorMatch = (i: number) => {
    const dr = data[i] - r0;
    const dg = data[i + 1] - g0;
    const db = data[i + 2] - b0;
    return dr * dr + dg * dg + db * db <= tolerance * tolerance;
  };

  const setPixelBackground = (i: number) => {
    data[i] = 0; // R
    data[i + 1] = 0; // G
    data[i + 2] = 0; // B
    data[i + 3] = 255; // A
  };

  while (stack.length > 0) {
    const [x, y] = stack.pop()!;
    if (x < 0 || x >= width || y < 0 || y >= height) continue;

    const pixelIndex = y * width + x;
    const dataIndex = pixelIndex * 4;
    if (visited[pixelIndex]) continue;

    visited[pixelIndex] = 1;

    if (colorMatch(dataIndex)) {
      setPixelBackground(dataIndex);
      stack.push([x + 1, y]);
      stack.push([x - 1, y]);
      stack.push([x, y + 1]);
      stack.push([x, y - 1]);
    }
  }

  ctx.putImageData(imageData, 0, 0);
}

export function focus_on_grey(canvas: HTMLCanvasElement) {
  if (!canvas) return;

  const ctx = canvas.getContext("2d");
  if (!ctx) return;

  const width = canvas.width;
  const height = canvas.height;

  const imageData = ctx.getImageData(0, 0, width, height);
  const data = imageData.data;

  for (let i = 0; i < data.length; i += 4) {
    const r = data[i];
    const g = data[i + 1];
    const b = data[i + 2];
    const brightness = 0.299 * r + 0.587 * g + 0.114 * b;
    if (brightness > 225) {
      data[i] = 255; // R
      data[i + 1] = 255; // G
      data[i + 2] = 255; // B
    }
    if (brightness < 30) {
      data[i] = 0; // R
      data[i + 1] = 0; // G
      data[i + 2] = 0; // B
    }
  }

  ctx.putImageData(imageData, 0, 0);
}

export function stretchBrightnessContrast(
  canvas: HTMLCanvasElement,
  option: boolean = false
) {
  const ctx = canvas.getContext("2d");
  if (!ctx) return;

  const width = canvas.width;
  const height = canvas.height;
  const imageData = ctx.getImageData(0, 0, width, height);
  const data = imageData.data;

  const isBackground = (r: number, g: number, b: number) => {
    return r === 0 && g === 0 && b === 0;
  };

  let minL = 255;
  let maxL = 0;

  // Step 1: Find min and max luminance among non-background pixels
  for (let i = 0; i < data.length; i += 4) {
    const r = data[i];
    const g = data[i + 1];
    const b = data[i + 2];

    if (isBackground(r, g, b)) continue;

    const luminance = 0.299 * r + 0.587 * g + 0.114 * b;

    if (option) {
      // set all

      if (luminance > 10 && luminance < 245) {
        minL = Math.min(minL, luminance);
        maxL = Math.max(maxL, luminance);
      }
    } else {
      minL = Math.min(minL, luminance);
      maxL = Math.max(maxL, luminance);
    }

    // minL = Math.min(minL, luminance);
    // maxL = Math.max(maxL, luminance);
  }

  if (minL === maxL) return; // Avoid division by zero
  console.log(`Stretching brightness values from ${minL} to ${maxL}`);

  const stretch = (value: number) => ((value - minL) * 255) / (maxL - minL);

  // Step 2: Stretch brightness on non-background pixels
  for (let i = 0; i < data.length; i += 4) {
    const r = data[i];
    const g = data[i + 1];
    const b = data[i + 2];

    if (isBackground(r, g, b)) continue;

    data[i] = stretch(r); // R
    data[i + 1] = stretch(g); // G
    data[i + 2] = stretch(b); // B
    // Alpha remains unchanged
  }

  ctx.putImageData(imageData, 0, 0);
}

export async function generateHistogram(min: number, max: number) {
  const canvas = document.getElementById("imageCanvas") as HTMLCanvasElement;
  const histogramCanvas = document.getElementById(
    "histogramCanvas"
  ) as HTMLCanvasElement;
  if (!canvas || !histogramCanvas) return;

  const ctx = canvas.getContext("2d");
  const histCtx = histogramCanvas.getContext("2d");
  if (!ctx || !histCtx) return;

  const dpr = window.devicePixelRatio || 1;

  // Set canvas size based on devicePixelRatio for higher resolution
  const cssWidth = histogramCanvas.clientWidth;
  const cssHeight = histogramCanvas.clientHeight;
  histogramCanvas.width = cssWidth * dpr;
  histogramCanvas.height = cssHeight * dpr;
  histCtx.setTransform(dpr, 0, 0, dpr, 0, 0); // Scale the drawing context

  const { width, height } = canvas;
  const imageData = ctx.getImageData(0, 0, width, height);
  const data = imageData.data;

  // Histogram erstellen
  const brightnessCounts = new Array(256).fill(0);
  for (let i = 0; i < data.length; i += 4) {
    const r = data[i];
    const g = data[i + 1];
    const b = data[i + 2];
    const brightness = Math.round(0.299 * r + 0.587 * g + 0.114 * b);
    brightnessCounts[brightness]++;
  }

  const visibleCounts = brightnessCounts.slice(min, max + 1);
  const maxCount = Math.max(...visibleCounts);

  histCtx.clearRect(0, 0, histogramCanvas.width, histogramCanvas.height);

  const margin = 40;
  const plotWidth = cssWidth - margin * 2;
  const plotHeight = cssHeight - margin * 2;

  // Axes
  histCtx.strokeStyle = "black";
  histCtx.beginPath();
  histCtx.moveTo(margin, margin);
  histCtx.lineTo(margin, cssHeight - margin);
  histCtx.lineTo(cssWidth - margin, cssHeight - margin);
  histCtx.stroke();

  // Bars
  const barWidth = plotWidth / (max - min + 1);
  visibleCounts.forEach((count, i) => {
    const heightRatio = count / maxCount;
    const barHeight = heightRatio * plotHeight;
    histCtx.fillStyle = "#fb923c";
    histCtx.fillRect(
      margin + i * barWidth,
      cssHeight - margin - barHeight,
      barWidth,
      barHeight
    );
  });

  const langData = await getLanguageData("xray");
  console.log("langdata:" + langData["brightness"]);
  // Labels
  histCtx.fillStyle = "black";
  histCtx.font = "12px sans-serif";
  histCtx.textAlign = "center";
  histCtx.fillText(min.toString(), margin, cssHeight - 5);
  histCtx.fillText(max.toString(), cssWidth - margin, cssHeight - 5);
  histCtx.fillText(langData["brightness"], cssWidth / 2, cssHeight - 5);
  //TODO hier weitermachen
  histCtx.save();
  histCtx.translate(10, cssHeight / 2);
  histCtx.rotate(-Math.PI / 2);
  histCtx.textAlign = "center";
  histCtx.fillText(langData["count"], 0, 0);
  histCtx.restore();
}
