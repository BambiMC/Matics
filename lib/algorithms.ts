export type HsvRange = {
  hMin: number;
  hMax: number;
  sMin: number;
  sMax: number;
  vMin: number;
  vMax: number;
};

function rgbToHsvCv(r: number, g: number, b: number) {
  const rNorm = r / 255;
  const gNorm = g / 255;
  const bNorm = b / 255;
  const cMax = Math.max(rNorm, gNorm, bNorm);
  const cMin = Math.min(rNorm, gNorm, bNorm);
  const delta = cMax - cMin;

  let h = 0;
  if (delta !== 0) {
    if (cMax === rNorm) h = 60 * (((gNorm - bNorm) / delta) % 6);
    else if (cMax === gNorm) h = 60 * ((bNorm - rNorm) / delta + 2);
    else h = 60 * ((rNorm - gNorm) / delta + 4);
  }
  if (h < 0) h += 360;

  const s = cMax === 0 ? 0 : delta / cMax;
  const v = cMax;

  const hCv = Math.round(h / 2); // OpenCV hue range 0-179
  const sCv = Math.round(s * 255);
  const vCv = Math.round(v * 255);
  return [hCv, sCv, vCv] as const;
}

export function segmentByHsv(
  sourceCanvas: HTMLCanvasElement,
  maskCanvas: HTMLCanvasElement,
  segmentedCanvas: HTMLCanvasElement,
  range: HsvRange,
) {
  if (!sourceCanvas || !maskCanvas || !segmentedCanvas) return;

  const width = sourceCanvas.width;
  const height = sourceCanvas.height;
  if (!width || !height) return;

  // Align output canvas sizes
  maskCanvas.width = width;
  maskCanvas.height = height;
  segmentedCanvas.width = width;
  segmentedCanvas.height = height;

  const srcCtx = sourceCanvas.getContext("2d");
  const maskCtx = maskCanvas.getContext("2d");
  const segCtx = segmentedCanvas.getContext("2d");
  if (!srcCtx || !maskCtx || !segCtx) return;

  const srcData = srcCtx.getImageData(0, 0, width, height);
  const maskData = maskCtx.createImageData(width, height);
  const segData = segCtx.createImageData(width, height);

  for (let i = 0; i < srcData.data.length; i += 4) {
    const r = srcData.data[i];
    const g = srcData.data[i + 1];
    const b = srcData.data[i + 2];

    const [hCv, sCv, vCv] = rgbToHsvCv(r, g, b);
    const within =
      hCv >= range.hMin &&
      hCv <= range.hMax &&
      sCv >= range.sMin &&
      sCv <= range.sMax &&
      vCv >= range.vMin &&
      vCv <= range.vMax;

    const maskValue = within ? 255 : 0;
    maskData.data[i] = maskValue;
    maskData.data[i + 1] = maskValue;
    maskData.data[i + 2] = maskValue;
    maskData.data[i + 3] = 255;

    segData.data[i] = within ? r : 0;
    segData.data[i + 1] = within ? g : 0;
    segData.data[i + 2] = within ? b : 0;
    segData.data[i + 3] = 255;
  }

  maskCtx.putImageData(maskData, 0, 0);
  segCtx.putImageData(segData, 0, 0);
}

export function autoSegmentHsv(sourceCanvas: HTMLCanvasElement): HsvRange {
  if (!sourceCanvas) {
    return {
      hMin: 0,
      hMax: 179,
      sMin: 0,
      sMax: 255,
      vMin: 0,
      vMax: 255,
    };
  }

  const ctx = sourceCanvas.getContext("2d");
  if (!ctx) {
    return {
      hMin: 0,
      hMax: 179,
      sMin: 0,
      sMax: 255,
      vMin: 0,
      vMax: 255,
    };
  }

  const width = sourceCanvas.width;
  const height = sourceCanvas.height;
  if (!width || !height) {
    return {
      hMin: 0,
      hMax: 179,
      sMin: 0,
      sMax: 255,
      vMin: 0,
      vMax: 255,
    };
  }

  const imageData = ctx.getImageData(0, 0, width, height);
  const data = imageData.data;

  // Histograms for HSV components
  const hHistogram = new Array(180).fill(0);
  const sHistogram = new Array(256).fill(0);
  const vHistogram = new Array(256).fill(0);

  // Build histograms (skip pure black and white pixels for better color detection)
  for (let i = 0; i < data.length; i += 4) {
    const r = data[i];
    const g = data[i + 1];
    const b = data[i + 2];

    // Skip near-black and near-white pixels
    const brightness = (r + g + b) / 3;
    if (brightness < 15 || brightness > 240) continue;

    const [hCv, sCv, vCv] = rgbToHsvCv(r, g, b);

    // Skip low saturation pixels (grayscale-ish)
    if (sCv < 30) continue;

    hHistogram[Math.min(hCv, 179)]++;
    sHistogram[Math.min(sCv, 255)]++;
    vHistogram[Math.min(vCv, 255)]++;
  }

  // Find peaks in histograms
  const hPeaks = findPeaks(hHistogram, 10);
  const sPeaks = findPeaks(sHistogram, 20);
  const vPeaks = findPeaks(vHistogram, 20);

  // Get ranges from peaks
  let hMin = 0,
    hMax = 179,
    sMin = 0,
    sMax = 255,
    vMin = 0,
    vMax = 255;

  if (hPeaks.length > 0) {
    const hPeak = hPeaks[0];
    const hRange = 15; // tolerance
    hMin = Math.max(0, hPeak - hRange);
    hMax = Math.min(179, hPeak + hRange);
  }

  if (sPeaks.length > 0) {
    const sPeak = sPeaks[0];
    const sRange = 40;
    sMin = Math.max(0, sPeak - sRange);
    sMax = Math.min(255, sPeak + sRange);
  }

  if (vPeaks.length > 0) {
    const vPeak = vPeaks[0];
    const vRange = 50;
    vMin = Math.max(0, vPeak - vRange);
    vMax = Math.min(255, vPeak + vRange);
  }

  return { hMin, hMax, sMin, sMax, vMin, vMax };
}

function findPeaks(histogram: number[], minDistance: number): number[] {
  const peaks: number[] = [];

  for (let i = minDistance; i < histogram.length - minDistance; i++) {
    let isPeak = true;

    // Check if it's a local maximum
    for (let j = 1; j <= minDistance; j++) {
      if (histogram[i - j] > histogram[i] || histogram[i + j] > histogram[i]) {
        isPeak = false;
        break;
      }
    }

    // Avoid peaks too close to existing ones
    if (isPeak) {
      for (const peak of peaks) {
        if (Math.abs(i - peak) < minDistance) {
          isPeak = false;
          break;
        }
      }
    }

    if (isPeak && histogram[i] > 0) {
      peaks.push(i);
    }
  }

  // Sort by histogram value (descending)
  peaks.sort((a, b) => histogram[b] - histogram[a]);

  return peaks;
}

export type KMeansResult = {
  k: number;
  centroids: Array<{
    h: number;
    s: number;
    v: number;
    r: number;
    g: number;
    b: number;
    count: number;
  }>;
};

export function segmentByKMeans(
  sourceCanvas: HTMLCanvasElement,
  segmentedCanvas: HTMLCanvasElement,
  k: number = 4,
  maxIter: number = 12,
  sampleStep: number = 6,
): KMeansResult | null {
  if (!sourceCanvas || !segmentedCanvas) return null;

  const width = sourceCanvas.width;
  const height = sourceCanvas.height;
  if (!width || !height) return null;

  const srcCtx = sourceCanvas.getContext("2d");
  const segCtx = segmentedCanvas.getContext("2d");
  if (!srcCtx || !segCtx) return null;

  const imageData = srcCtx.getImageData(0, 0, width, height);
  const data = imageData.data;

  // Sample pixels to speed up clustering
  const samples: Array<{
    h: number;
    s: number;
    v: number;
    r: number;
    g: number;
    b: number;
  }> = [];

  for (let y = 0; y < height; y += sampleStep) {
    for (let x = 0; x < width; x += sampleStep) {
      const idx = (y * width + x) * 4;
      const r = data[idx];
      const g = data[idx + 1];
      const b = data[idx + 2];

      const [hCv, sCv, vCv] = rgbToHsvCv(r, g, b);
      // skip very dark/bright or low saturation pixels to focus on colors
      const brightness = (r + g + b) / 3;
      if (brightness < 10 || brightness > 245) continue;
      if (sCv < 20) continue;

      samples.push({ h: hCv, s: sCv, v: vCv, r, g, b });
    }
  }

  if (samples.length === 0) return null;

  // If not enough samples, reduce k
  k = Math.max(1, Math.min(k, Math.floor(samples.length / 10) || 1));

  // Initialize centroids by sampling k random points
  const centroids: Array<{
    h: number;
    s: number;
    v: number;
    r: number;
    g: number;
    b: number;
  }> = [];
  const used = new Set<number>();
  while (centroids.length < k) {
    const idx = Math.floor(Math.random() * samples.length);
    if (used.has(idx)) continue;
    used.add(idx);
    centroids.push({ ...samples[idx] });
  }

  // K-means iterations on sampled points
  const assignments = new Array(samples.length).fill(0);
  for (let iter = 0; iter < maxIter; iter++) {
    let changed = false;

    // Assignment step
    for (let i = 0; i < samples.length; i++) {
      const s = samples[i];
      let best = 0;
      let bestDist = Infinity;
      for (let c = 0; c < centroids.length; c++) {
        const cent = centroids[c];
        // Distance in HSV space (h scaled naively)
        const dh = cent.h - s.h;
        const ds = cent.s - s.s;
        const dv = cent.v - s.v;
        const dist = dh * dh + ds * ds + dv * dv;
        if (dist < bestDist) {
          bestDist = dist;
          best = c;
        }
      }
      if (assignments[i] !== best) {
        changed = true;
        assignments[i] = best;
      }
    }

    // Update step
    const sums = new Array(centroids.length)
      .fill(0)
      .map(() => ({ h: 0, s: 0, v: 0, r: 0, g: 0, b: 0, count: 0 }) as any);
    for (let i = 0; i < samples.length; i++) {
      const a = assignments[i];
      const s = samples[i];
      sums[a].h += s.h;
      sums[a].s += s.s;
      sums[a].v += s.v;
      sums[a].r += s.r;
      sums[a].g += s.g;
      sums[a].b += s.b;
      sums[a].count += 1;
    }

    for (let c = 0; c < centroids.length; c++) {
      if (sums[c].count === 0) continue;
      centroids[c].h = sums[c].h / sums[c].count;
      centroids[c].s = sums[c].s / sums[c].count;
      centroids[c].v = sums[c].v / sums[c].count;
      centroids[c].r = Math.round(sums[c].r / sums[c].count);
      centroids[c].g = Math.round(sums[c].g / sums[c].count);
      centroids[c].b = Math.round(sums[c].b / sums[c].count);
    }

    if (!changed) break;
  }

  // Assign every pixel to nearest centroid and write segmented image
  const outData = segCtx.createImageData(width, height);
  for (let i = 0; i < data.length; i += 4) {
    const r = data[i];
    const g = data[i + 1];
    const b = data[i + 2];
    const [hCv, sCv, vCv] = rgbToHsvCv(r, g, b);

    let best = 0;
    let bestDist = Infinity;
    for (let c = 0; c < centroids.length; c++) {
      const cent = centroids[c];
      const dh = cent.h - hCv;
      const ds = cent.s - sCv;
      const dv = cent.v - vCv;
      const dist = dh * dh + ds * ds + dv * dv;
      if (dist < bestDist) {
        bestDist = dist;
        best = c;
      }
    }

    const cent = centroids[best];
    outData.data[i] = cent.r;
    outData.data[i + 1] = cent.g;
    outData.data[i + 2] = cent.b;
    outData.data[i + 3] = 255;
  }

  segmentedCanvas.width = width;
  segmentedCanvas.height = height;
  segCtx.putImageData(outData, 0, 0);

  return {
    k: centroids.length,
    centroids: centroids.map((c) => ({
      h: c.h,
      s: c.s,
      v: c.v,
      r: c.r,
      g: c.g,
      b: c.b,
      count: 0,
    })),
  } as KMeansResult;
}
