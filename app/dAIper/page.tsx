"use client";
import React, { useRef, useState, useEffect } from "react";
import Button from "@app/components/Button/Button";
import SegCanvas from "@app/components/SegCanvas/SegCanvas";
import FiltersPanel from "@app/components/FiltersPanel/FiltersPanel";
import SegmentMenu from "@app/components/SegmentMenu/SegmentMenu";
import * as imageProcessing from "@lib/imageProcessing";
import {
  segmentByHsv,
  autoSegmentHsv,
  segmentByKMeans,
  segmentByRegionGrow,
} from "@lib/algorithms";
import { useLanguageData } from "@data/languageLoader";

const DEFAULT_HSV = {
  hMin: 0,
  hMax: 50,
  sMin: 0,
  sMax: 255,
  vMin: 0,
  vMax: 150,
};

const Projects: React.FC = () => {
  const fileInputRef = useRef<HTMLInputElement | null>(null);
  const canvasRef = useRef<HTMLCanvasElement | null>(null);
  const maskCanvasRef = useRef<HTMLCanvasElement | null>(null);
  const segmentedCanvasRef = useRef<HTMLCanvasElement | null>(null);

  const [imageSrc, setImageSrc] = useState<string | null>(null);
  const [originalImageSrc, setOriginalImageSrc] = useState<string | null>(null);

  const [contrast, setContrast] = useState(1);
  const [sharpen, setSharpen] = useState(0);
  const [noise, setNoise] = useState(0);
  const [blur, setBlur] = useState(0);
  const [hue, setHue] = useState(0);

  const [histogramMinValue, setHistogramMinValue] = useState(0);
  const [histogramMaxValue, setHistogramMaxValue] = useState(255);

  const [scale, setScale] = useState(1);
  const zoomIn = () => setScale((prev) => Math.min(prev + 0.1, 5));
  const zoomOut = () => setScale((prev) => Math.max(prev - 0.1, 1));

  const [hMin, setHMin] = useState(DEFAULT_HSV.hMin);
  const [hMax, setHMax] = useState(DEFAULT_HSV.hMax);
  const [sMin, setSMin] = useState(DEFAULT_HSV.sMin);
  const [sMax, setSMax] = useState(DEFAULT_HSV.sMax);
  const [vMin, setVMin] = useState(DEFAULT_HSV.vMin);
  const [vMax, setVMax] = useState(DEFAULT_HSV.vMax);

  const [showOriginal, setShowOriginal] = useState(false);

  const [appliedAlgorithms, setAppliedAlgorithms] = useState<string[]>([]);
  const [selectedAlgorithm, setSelectedAlgorithm] = useState<string | null>(
    null,
  );
  const [kClusters, setKClusters] = useState(4);
  const [kCentroids, setKCentroids] = useState<any[]>([]);
  const [visibleCentroids, setVisibleCentroids] = useState<boolean[]>([]);
  const [regionHThresh, setRegionHThresh] = useState(70);
  const [regionSThresh, setRegionSThresh] = useState(200);
  const [regionVThresh, setRegionVThresh] = useState(200);
  const [regionConnectivity, setRegionConnectivity] = useState<4 | 8>(4);
  const [regionMinSize, setRegionMinSize] = useState(1);
  const [lastSeed, setLastSeed] = useState<{ x: number; y: number } | null>(
    null,
  );

  const resetFilters = () => {
    setContrast(1);
    setSharpen(0);
    setNoise(0);
    setHue(0);
    setHMin(DEFAULT_HSV.hMin);
    setHMax(DEFAULT_HSV.hMax);
    setSMin(DEFAULT_HSV.sMin);
    setSMax(DEFAULT_HSV.sMax);
    setVMin(DEFAULT_HSV.vMin);
    setVMax(DEFAULT_HSV.vMax);
    setAppliedAlgorithms([]);
    setShowOriginal(false);

    if (originalImageSrc) {
      setImageSrc(originalImageSrc);
    }
  };

  const ensureStyleSize = (c: HTMLCanvasElement | null) => {
    if (!c) return;
    // revert to CSS-controlled sizing to avoid forcing large pixel sizes
    try {
      c.style.width = "";
      c.style.height = "";
    } catch (e) {
      /* ignore */
    }
  };
  const runRegionAtSeed = (x?: number, y?: number) => {
    if (
      !canvasRef.current ||
      !maskCanvasRef.current ||
      !segmentedCanvasRef.current
    ) {
      console.warn("runRegionAtSeed: canvases not ready");
      return;
    }
    const sx = x ?? lastSeed?.x;
    const sy = y ?? lastSeed?.y;
    if (sx == null || sy == null) {
      console.warn("runRegionAtSeed: no seed provided");
      return;
    }

    try {
      // draw marker on mask to indicate seed
      const mctx = maskCanvasRef.current.getContext("2d");
      if (mctx) {
        mctx.save();
        mctx.fillStyle = "rgba(255,0,0,0.9)";
        mctx.beginPath();
        mctx.arc(sx, sy, 3, 0, Math.PI * 2);
        mctx.fill();
        mctx.restore();
      }

      segmentByRegionGrow(
        canvasRef.current,
        maskCanvasRef.current,
        segmentedCanvasRef.current,
        sx,
        sy,
        {
          h: regionHThresh,
          s: regionSThresh,
          v: regionVThresh,
          connectivity: regionConnectivity,
          minSize: regionMinSize,
        },
      );

      ensureStyleSize(maskCanvasRef.current);
      ensureStyleSize(segmentedCanvasRef.current);

      // inspect result
      const sctx = segmentedCanvasRef.current.getContext("2d");
      if (sctx) {
        const id = sctx.getImageData(
          0,
          0,
          segmentedCanvasRef.current.width,
          segmentedCanvasRef.current.height,
        );
        let count = 0;
        let minX = Infinity,
          minY = Infinity,
          maxX = -Infinity,
          maxY = -Infinity;
        for (let i = 0; i < id.data.length; i += 4) {
          if (
            id.data[i] !== 0 ||
            id.data[i + 1] !== 0 ||
            id.data[i + 2] !== 0
          ) {
            const px = (i / 4) % segmentedCanvasRef.current.width;
            const py = Math.floor(i / 4 / segmentedCanvasRef.current.width);
            minX = Math.min(minX, px);
            minY = Math.min(minY, py);
            maxX = Math.max(maxX, px);
            maxY = Math.max(maxY, py);
            count++;
          }
        }
        if (count > 0 && isFinite(minX)) {
          // draw bbox to make region visible (ensure full stroke is inside canvas)
          sctx.save();
          sctx.strokeStyle = "red";
          const strokeW = 8;
          sctx.lineWidth = strokeW;
          const half = strokeW / 2;
          const rawX = Math.floor(minX - 1);
          const rawY = Math.floor(minY - 1);
          const rawW = Math.ceil(maxX - minX + 3);
          const rawH = Math.ceil(maxY - minY + 3);
          const rx = Math.max(half, rawX);
          const ry = Math.max(half, rawY);
          const rwidth = Math.max(
            0,
            Math.min(
              rawW,
              Math.floor(segmentedCanvasRef.current.width - rx - half),
            ),
          );
          const rheight = Math.max(
            0,
            Math.min(
              rawH,
              Math.floor(segmentedCanvasRef.current.height - ry - half),
            ),
          );
          sctx.strokeRect(rx, ry, rwidth, rheight);
          sctx.restore();
        }
      }

      setSelectedAlgorithm("segment_region");
    } catch (err) {
      console.error("runRegionAtSeed failed", err);
    }
  };

  const handleFileChange = (e: React.ChangeEvent<HTMLInputElement> | File) => {
    const file = e instanceof File ? e : e.target.files?.[0];
    if (file && file.type.startsWith("image/")) {
      const reader = new FileReader();
      reader.onloadend = () => {
        const result = reader.result as string;
        setImageSrc(result);
        setOriginalImageSrc(result);
      };
      reader.readAsDataURL(file);
    }
  };

  const handleButtonClick = () => {
    fileInputRef.current?.click();
  };

  const loadExampleImage = (index?: number) => {
    const exampleImages = [
      "/exampleImages/bd7_1.png",
      "/exampleImages/bd7_2.png",
    ];
    const file = exampleImages[index || 0];
    resetFilters();
    setImageSrc(file);
    setOriginalImageSrc(file);
  };

  const handleDownload = () => {
    if (!canvasRef.current) return;

    const link = document.createElement("a");
    link.download = "dAIper_image.png";
    link.href = canvasRef.current.toDataURL("image/png");
    link.click();
  };

  const handleAutoSegment = () => {
    if (!canvasRef.current) return;
    const range = autoSegmentHsv(canvasRef.current);
    setHMin(range.hMin);
    setHMax(range.hMax);
    setSMin(range.sMin);
    setSMax(range.sMax);
    setVMin(range.vMin);
    setVMax(range.vMax);
  };

  // Run segmentation on demand (only when user requests)
  const runSegmentHsv = () => {
    if (
      !canvasRef.current ||
      !maskCanvasRef.current ||
      !segmentedCanvasRef.current
    )
      return;
    segmentByHsv(
      canvasRef.current,
      maskCanvasRef.current,
      segmentedCanvasRef.current,
      {
        hMin,
        hMax,
        sMin,
        sMax,
        vMin,
        vMax,
      },
    );
    ensureStyleSize(maskCanvasRef.current);
    ensureStyleSize(segmentedCanvasRef.current);
    setSelectedAlgorithm("segment_hsv");
  };

  const runKMeans = () => {
    const srcCanvas = canvasRef.current;
    const targetCanvas = segmentedCanvasRef.current;
    if (!targetCanvas) return;

    const doSeg = (source: HTMLCanvasElement) => {
      const res = segmentByKMeans(source, targetCanvas, kClusters);
      if (res) {
        setKCentroids(res.centroids || []);
        // initialize visibility for new centroids
        setVisibleCentroids(new Array(res.centroids.length).fill(true));
        // paint using returned centroids (segmentByKMeans already wrote output)
      }
      setSelectedAlgorithm("segment_kmeans");
      ensureStyleSize(targetCanvas);
    };

    if (srcCanvas && srcCanvas.width > 0 && srcCanvas.height > 0) {
      doSeg(srcCanvas);
    } else if (imageSrc) {
      const img = new Image();
      img.crossOrigin = "anonymous";
      img.src = imageSrc;
      img.onload = () => {
        const tmp = document.createElement("canvas");
        tmp.width = img.width;
        tmp.height = img.height;
        const tctx = tmp.getContext("2d");
        if (!tctx) return;
        tctx.drawImage(img, 0, 0);
        doSeg(tmp);
      };
    }
  };

  // paint segmented output from stored centroids without recomputing clusters
  const paintFromCentroids = (visible?: boolean[]) => {
    if (!canvasRef.current || !segmentedCanvasRef.current) return;
    if (!kCentroids || kCentroids.length === 0) return;
    const src = canvasRef.current;
    const tgt = segmentedCanvasRef.current;
    const width = src.width;
    const height = src.height;
    if (!width || !height) return;
    const sctx = src.getContext("2d");
    const tctx = tgt.getContext("2d");
    if (!sctx || !tctx) return;
    const imageData = sctx.getImageData(0, 0, width, height);
    const data = imageData.data;
    const out = tctx.createImageData(width, height);

    for (let i = 0; i < data.length; i += 4) {
      const r = data[i];
      const g = data[i + 1];
      const b = data[i + 2];
      let best = 0;
      let bestDist = Infinity;
      for (let c = 0; c < kCentroids.length; c++) {
        const cent = kCentroids[c];
        const dr = cent.r - r;
        const dg = cent.g - g;
        const db = cent.b - b;
        const dist = dr * dr + dg * dg + db * db;
        if (dist < bestDist) {
          bestDist = dist;
          best = c;
        }
      }
      const vis = visible && visible.length > best ? visible[best] : true;
      if (!vis) {
        out.data[i] = 0;
        out.data[i + 1] = 0;
        out.data[i + 2] = 0;
        out.data[i + 3] = 0;
      } else {
        const cent = kCentroids[best];
        out.data[i] = cent.r;
        out.data[i + 1] = cent.g;
        out.data[i + 2] = cent.b;
        out.data[i + 3] = 255;
      }
    }

    tgt.width = width;
    tgt.height = height;
    tctx.putImageData(out, 0, 0);
  };

  const toggleCentroid = (index: number) => {
    if (!kCentroids || index < 0 || index >= kCentroids.length) return;
    const next = [...visibleCentroids];
    // ensure length
    if (next.length !== kCentroids.length) next.length = kCentroids.length;
    next[index] = !next[index];
    setVisibleCentroids(next);
    // repaint using existing centroids
    paintFromCentroids(next);
  };

  const runAutoSegment = () => {
    const srcCanvas = canvasRef.current;
    const applyRange = (source: HTMLCanvasElement, range: any) => {
      setHMin(range.hMin);
      setHMax(range.hMax);
      setSMin(range.sMin);
      setSMax(range.sMax);
      setVMin(range.vMin);
      setVMax(range.vMax);
      setSelectedAlgorithm("auto_segment_hsv");
      if (maskCanvasRef.current && segmentedCanvasRef.current) {
        segmentByHsv(
          source,
          maskCanvasRef.current,
          segmentedCanvasRef.current,
          range,
        );
        ensureStyleSize(maskCanvasRef.current);
        ensureStyleSize(segmentedCanvasRef.current);
      }
    };

    if (srcCanvas && srcCanvas.width > 0 && srcCanvas.height > 0) {
      const range = autoSegmentHsv(srcCanvas);
      if (range) applyRange(srcCanvas, range);
    } else if (imageSrc) {
      const img = new Image();
      img.crossOrigin = "anonymous";
      img.src = imageSrc;
      img.onload = () => {
        const tmp = document.createElement("canvas");
        tmp.width = img.width;
        tmp.height = img.height;
        const tctx = tmp.getContext("2d");
        if (!tctx) return;
        tctx.drawImage(img, 0, 0);
        const range = autoSegmentHsv(tmp);
        if (range) applyRange(tmp, range);
      };
    }
  };

  const [awaitingSeed, setAwaitingSeed] = useState(false);

  const handleCanvasClick = (e: React.MouseEvent<HTMLCanvasElement>) => {
    if (!canvasRef.current) return;
    if (!awaitingSeed) return;

    const rect = canvasRef.current.getBoundingClientRect();
    const clickX = e.clientX - rect.left;
    const clickY = e.clientY - rect.top;

    // convert CSS coords to canvas pixel coords
    const canvasX = Math.round((clickX * canvasRef.current.width) / rect.width);
    const canvasY = Math.round(
      (clickY * canvasRef.current.height) / rect.height,
    );

    if (!maskCanvasRef.current || !segmentedCanvasRef.current) {
      console.warn("mask or segmented canvas not available for region grow");
      setAwaitingSeed(false);
      return;
    }

    try {
      // draw a small marker on the visible canvas to confirm seed position
      const vctx = canvasRef.current.getContext("2d");
      if (vctx) {
        vctx.save();
        vctx.fillStyle = "rgba(255,0,0,0.8)";
        vctx.beginPath();
        vctx.arc(canvasX, canvasY, 3, 0, Math.PI * 2);
        vctx.fill();
        vctx.restore();
      }

      // store last seed for manual apply
      setLastSeed({ x: canvasX, y: canvasY });

      // use UI-configured thresholds
      segmentByRegionGrow(
        canvasRef.current,
        maskCanvasRef.current,
        segmentedCanvasRef.current,
        canvasX,
        canvasY,
        {
          h: regionHThresh,
          s: regionSThresh,
          v: regionVThresh,
          connectivity: regionConnectivity,
          minSize: regionMinSize,
        },
      );

      // make sure canvases display at their pixel size
      ensureStyleSize(maskCanvasRef.current);
      ensureStyleSize(segmentedCanvasRef.current);

      // verify segmented output non-empty; if empty, retry with looser thresholds
      try {
        const sctx = segmentedCanvasRef.current.getContext("2d");
        if (sctx) {
          const id = sctx.getImageData(
            0,
            0,
            segmentedCanvasRef.current.width,
            segmentedCanvasRef.current.height,
          );
          let hasPixels = false;
          for (let i = 3; i < id.data.length; i += 4) {
            if (id.data[i] !== 0) {
              hasPixels = true;
              break;
            }
          }
          if (!hasPixels) {
            console.info(
              "region grow produced empty output; retrying with looser thresholds",
            );
            segmentByRegionGrow(
              canvasRef.current,
              maskCanvasRef.current,
              segmentedCanvasRef.current,
              canvasX,
              canvasY,
              {
                h: Math.min(179, regionHThresh * 2),
                s: Math.min(255, regionSThresh * 2),
                v: Math.min(255, regionVThresh * 2),
                connectivity: regionConnectivity,
                minSize: regionMinSize,
              },
            );
            ensureStyleSize(maskCanvasRef.current);
            ensureStyleSize(segmentedCanvasRef.current);
          }
        }
      } catch (e) {
        console.warn("failed to inspect segmented output", e);
      }

      setSelectedAlgorithm("segment_region");
    } catch (err) {
      console.error("region grow failed", err);
    } finally {
      setAwaitingSeed(false);
    }
  };
  useEffect(() => {
    if (!imageSrc || !canvasRef.current) return;
    const prevImageSrcRef = (Projects as any)._prevImageSrcRef || {
      current: null,
    };
    if (!(Projects as any)._prevImageSrcRef)
      (Projects as any)._prevImageSrcRef = prevImageSrcRef;
    const isNewImage = imageSrc !== prevImageSrcRef.current;

    import("glfx").then((glfx) => {
      const visibleCanvas = canvasRef.current!;
      const glfxCanvas = glfx.canvas();

      const img = new Image();
      img.crossOrigin = "anonymous";
      img.src = imageSrc;

      img.onload = () => {
        try {
          const texture = glfxCanvas.texture(img);
          if (!texture) {
            console.error("Failed to create texture from image");
            return;
          }

          // Start drawing image to fxCanvas
          let fxCanvas = glfxCanvas.draw(texture);

          if (!showOriginal) {
            // Clamp and normalize values
            const safeContrast = isNaN(contrast)
              ? 1
              : Math.max(0, Math.min(3, contrast));
            const safeSharpen = Math.max(0, Math.min(1, sharpen));
            const safeNoise = Math.max(0, Math.min(1, noise));
            const safeBlur = Math.max(0, Math.min(50, blur));
            const safeHue = Math.max(-180, Math.min(180, hue)) / 360; // Normalize to -0.5 ~ 0.5

            // Apply all GPU-based filters in order
            if (safeContrast !== 1)
              fxCanvas = fxCanvas.brightnessContrast(0, safeContrast - 1);
            if (safeHue !== 0) fxCanvas = fxCanvas.hueSaturation(safeHue, 0);
            if (safeBlur > 0) fxCanvas = fxCanvas.triangleBlur(safeBlur);
            if (safeSharpen > 0)
              fxCanvas = fxCanvas.unsharpMask(20, safeSharpen * 2);
            if (safeNoise > 0) fxCanvas = fxCanvas.noise(safeNoise * 0.5);
          }

          fxCanvas.update();

          // Render to intermediate CPU canvas for optional post-processing
          const tempCanvas = document.createElement("canvas");
          tempCanvas.width = img.width;
          tempCanvas.height = img.height;
          const tempCtx = tempCanvas.getContext("2d");
          if (!tempCtx) {
            console.error("Failed to get temp canvas context");
            return;
          }
          tempCtx.drawImage(glfxCanvas, 0, 0);

          // Don't run segmentation automatically on load — clear mask/output canvases only when a new image loads
          if (
            isNewImage &&
            maskCanvasRef.current &&
            segmentedCanvasRef.current
          ) {
            maskCanvasRef.current.width = img.width;
            maskCanvasRef.current.height = img.height;
            segmentedCanvasRef.current.width = img.width;
            segmentedCanvasRef.current.height = img.height;
            // sync CSS size so canvases are visible at full resolution
            ensureStyleSize(maskCanvasRef.current);
            ensureStyleSize(segmentedCanvasRef.current);
            const mctx = maskCanvasRef.current.getContext("2d");
            const sctx = segmentedCanvasRef.current.getContext("2d");
            if (mctx) mctx.clearRect(0, 0, img.width, img.height);
            if (sctx) sctx.clearRect(0, 0, img.width, img.height);
          }

          // Render to final visible canvas
          const visibleCtx = visibleCanvas.getContext("2d");
          if (!visibleCtx) {
            console.error("Failed to get visible canvas context");
            return;
          }

          visibleCanvas.width = img.width;
          visibleCanvas.height = img.height;
          visibleCtx.clearRect(0, 0, visibleCanvas.width, visibleCanvas.height);
          visibleCtx.drawImage(tempCanvas, 0, 0);
          // remember this image as the last processed image
          prevImageSrcRef.current = imageSrc;
          // generate histogram for the newly drawn image so it's visible on startup/load
          try {
            imageProcessing.generateHistogram(
              histogramMinValue,
              histogramMaxValue,
            );
          } catch (err) {
            console.warn("generateHistogram failed on image load:", err);
          }
        } catch (error) {
          console.error("Error during glfx image processing:", error);
        }
      };

      img.onerror = () => {
        console.error("Failed to load image for processing");
      };
    });
  }, [
    imageSrc,
    sharpen,
    blur,
    noise,
    contrast,
    hue,
    showOriginal,
    hMin,
    hMax,
    sMin,
    sMax,
    vMin,
    vMax,
  ]);

  const data = useLanguageData("dAIper");

  return (
    <main className="px-4 mx-auto w-screen max-w-9xl my-40 md:mt-20 lg:mt-24">
      {data && (
        <div>
          <h1 className="font-bold text-2xl my-4">{data["title"]}</h1>

          <h2 className="mb-4">{data["description1"]}</h2>
          <h2 className="mb-4">{data["description2"]}</h2>

          <div className="my-4 p-4 bg-fnbg-accent">
            <div className="flex flex-wrap items-center">
              <input
                type="file"
                accept="image/*"
                ref={fileInputRef}
                onChange={handleFileChange}
                className="hidden"
                aria-label="Upload Image"
              />
              <Button
                onClick={handleButtonClick}
                addClasses="border border-fnbg-purple rounded-none mx-2 mr-4"
              >
                {data["upload"]}
              </Button>
              <Button
                onClick={() => loadExampleImage(0)}
                addClasses="border border-fnbg-purple rounded-none mx-2"
              >
                {data["example1"]}
              </Button>
              <Button
                onClick={() => loadExampleImage(1)}
                addClasses="border border-fnbg-purple rounded-none mx-2"
              >
                {data["example2"]}
              </Button>
            </div>
            <div className="flex mt-4 mx-2 gap-4">
              <Button
                onClick={() => {
                  setSelectedAlgorithm("segment_hsv");
                  runSegmentHsv();
                }}
                addClasses={`border border-fnbg-purple rounded-none`}
              >
                {data["segment_hsv"]}
              </Button>
              <Button
                onClick={() => {
                  setSelectedAlgorithm("segment_kmeans");
                  runKMeans();
                }}
                addClasses={`border border-fnbg-purple rounded-none`}
              >
                {data["segment_kmeans"]}
              </Button>
              <Button
                onClick={() => {
                  setSelectedAlgorithm("segment_region");
                  // next canvas click will be used as seed
                  setAwaitingSeed(true);
                }}
                addClasses={`border border-fnbg-purple rounded-none`}
              >
                {data["segment_region"]}
              </Button>
            </div>
          </div>

          {imageSrc && (
            <div className="mt-6 flex gap-8 flex-col md:flex-row md:items-start">
              {/* Left Column: Filters and Controls */}
              <div className="flex flex-col gap-4 w-full md:w-1/4">
                <FiltersPanel
                  contrast={contrast}
                  setContrast={setContrast}
                  sharpen={sharpen}
                  setSharpen={setSharpen}
                  blur={blur}
                  setBlur={setBlur}
                  noise={noise}
                  setNoise={setNoise}
                  hue={hue}
                  setHue={setHue}
                  histogramMinValue={histogramMinValue}
                  setHistogramMinValue={setHistogramMinValue}
                  histogramMaxValue={histogramMaxValue}
                  setHistogramMaxValue={setHistogramMaxValue}
                  generateHistogram={() =>
                    imageProcessing.generateHistogram(
                      histogramMinValue,
                      histogramMaxValue,
                    )
                  }
                  data={data}
                  resetFilters={resetFilters}
                  showOriginal={showOriginal}
                  toggleShowOriginal={() => setShowOriginal((prev) => !prev)}
                />

                <SegmentMenu
                  selectedAlgorithm={selectedAlgorithm}
                  setSelectedAlgorithm={setSelectedAlgorithm}
                  hMin={hMin}
                  setHMin={setHMin}
                  hMax={hMax}
                  setHMax={setHMax}
                  sMin={sMin}
                  setSMin={setSMin}
                  sMax={sMax}
                  setSMax={setSMax}
                  vMin={vMin}
                  setVMin={setVMin}
                  vMax={vMax}
                  setVMax={setVMax}
                  runAutoSegment={runAutoSegment}
                  runSegmentHsv={runSegmentHsv}
                  runKMeans={runKMeans}
                  kClusters={kClusters}
                  setKClusters={setKClusters}
                  kCentroids={kCentroids}
                  visibleCentroids={visibleCentroids}
                  toggleCentroid={toggleCentroid}
                  regionHThresh={regionHThresh}
                  setRegionHThresh={setRegionHThresh}
                  regionSThresh={regionSThresh}
                  setRegionSThresh={setRegionSThresh}
                  regionVThresh={regionVThresh}
                  setRegionVThresh={setRegionVThresh}
                  awaitingSeed={awaitingSeed}
                  setAwaitingSeed={setAwaitingSeed}
                  regionConnectivity={regionConnectivity}
                  setRegionConnectivity={setRegionConnectivity}
                  regionMinSize={regionMinSize}
                  setRegionMinSize={setRegionMinSize}
                  lastSeed={lastSeed}
                  runRegionAtSeed={runRegionAtSeed}
                  data={data}
                />
              </div>
              {/* Right Column: All three canvases side-by-side */}
              <div className="flex-1 w-full md:w-3/4 flex flex-col gap-4">
                <div
                  className="flex flex-row gap-4 overflow-auto border border-fnbg-purple border-2 max-w-full max-h-[90vh]"
                  style={{ minWidth: "300px", minHeight: "300px" }}
                >
                  <div className="flex-1 min-w-[300px] flex flex-col items-start justify-start p-2">
                    <p className="font-semibold mb-1">
                      {data["original_image"]}
                    </p>
                    <div className="w-full h-full max-w-full max-h-[70vh] overflow-hidden flex items-center justify-center">
                      <canvas
                        id="imageCanvas"
                        className="block object-contain"
                        ref={canvasRef}
                        onClick={handleCanvasClick}
                        style={{
                          transform: `scale(${scale})`,
                          transformOrigin: "center center",
                          display: "block",
                          maxWidth: "100%",
                          maxHeight: "100%",
                        }}
                      />
                    </div>
                    <div className="mt-2 p-4 bg-fnbg-accent w-full flex items-center gap-2">
                      <div className="flex items-center gap-2">
                        <div className="flex gap-2 ml-2">
                          <Button
                            onClick={zoomIn}
                            addClasses="border border-fnbg-purple rounded-none text-xl font-bold"
                          >
                            +
                          </Button>
                          <Button
                            onClick={zoomOut}
                            addClasses="border border-fnbg-purple rounded-none text-xl font-bold"
                          >
                            -
                          </Button>
                        </div>
                      </div>
                      <div className="ml-auto">
                        <Button
                          onClick={handleDownload}
                          addClasses="border border-fnbg-purple rounded-none"
                        >
                          <img
                            src="../imgs/dl_icon.png"
                            alt="Download"
                            className="w-6 h-6"
                          />
                        </Button>
                      </div>
                    </div>
                  </div>

                  {(selectedAlgorithm === "segment_hsv" ||
                    selectedAlgorithm === "auto_segment_hsv" ||
                    selectedAlgorithm === "segment_region") && (
                    <div className="flex-1 min-w-[260px] p-2">
                      <SegCanvas
                        ref={maskCanvasRef as any}
                        title={data["mask"]}
                        bgClass="bg-fnbg-body"
                        downloadFilename="mask.png"
                      />
                    </div>
                  )}

                  <div className="flex-1 min-w-[260px] p-2">
                    <SegCanvas
                      ref={segmentedCanvasRef as any}
                      title={data["segmented_image"]}
                      bgClass="bg-fnbg-body"
                      downloadFilename="segmented.png"
                    />
                  </div>
                </div>
              </div>
            </div>
          )}
        </div>
      )}
    </main>
  );
};

export default Projects;
