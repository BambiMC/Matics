"use client";
import React, { useRef, useState, useEffect } from "react";
import Button from "@app/components/Button/Button";
import SegCanvas from "@app/components/SegCanvas/SegCanvas";
import FiltersPanel from "@app/components/FiltersPanel/FiltersPanel";
import SegmentMenu from "@app/components/SegmentMenu/SegmentMenu";
import * as imageProcessing from "@lib/imageProcessing";
import { segmentByHsv, autoSegmentHsv, segmentByKMeans } from "@lib/algorithms";
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
  const [hue, setHue] = useState(0);

  const [histogramMinValue, setHistogramMinValue] = useState(0);
  const [histogramMaxValue, setHistogramMaxValue] = useState(255);

  const [scale, setScale] = useState(1);
  const zoomIn = () => setScale((prev) => Math.min(prev + 0.1, 5));
  // Prevent zooming out below 100% (scale 1)
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
    link.download = "xray_image.png";
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

  const handleKMeans = () => {
    if (!canvasRef.current || !segmentedCanvasRef.current) return;
    const res = segmentByKMeans(
      canvasRef.current,
      segmentedCanvasRef.current,
      kClusters,
    );
    if (res) setKCentroids(res.centroids || []);
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
    setSelectedAlgorithm("segment_hsv");
  };

  const runKMeans = () => {
    const srcCanvas = canvasRef.current;
    const targetCanvas = segmentedCanvasRef.current;
    if (!targetCanvas) return;

    const doSeg = (source: HTMLCanvasElement) => {
      const res = segmentByKMeans(source, targetCanvas, kClusters);
      if (res) setKCentroids(res.centroids || []);
      setSelectedAlgorithm("segment_kmeans");
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
            const safeHue = Math.max(-180, Math.min(180, hue)) / 360; // Normalize to -0.5 ~ 0.5

            // Apply all GPU-based filters in order
            if (safeContrast !== 1)
              fxCanvas = fxCanvas.brightnessContrast(0, safeContrast - 1);
            if (safeHue !== 0) fxCanvas = fxCanvas.hueSaturation(safeHue, 0);
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

  const data = useLanguageData("xray");

  return (
    <main className="px-4 mx-auto w-screen max-w-9xl my-40 md:mt-20 lg:mt-24">
      {data && (
        <div>
          <h1 className="font-bold text-2xl my-4">{data["title"]}</h1>

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
                addClasses={`border rounded-none`}
              >
                segment_hsv
              </Button>
              <Button
                onClick={() => {
                  setSelectedAlgorithm("segment_kmeans");
                  runKMeans();
                }}
                addClasses={`border rounded-none`}
              >
                segment_kmeans
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
                  data={data}
                />
              </div>
              {/* Right Column: All three canvases side-by-side */}
              <div className="flex-1 w-full md:w-3/4 flex flex-col gap-4">
                <div
                  className="flex flex-row gap-4 overflow-auto border border-fnbg-purple border-2 max-w-full max-h-[90vh]"
                  style={{ minWidth: "300px", minHeight: "300px" }}
                >
                  <div className="flex-1 min-w-[300px] flex flex-col items-start justify-center p-2">
                    <p className="font-semibold mb-1">Original Image</p>
                    <div className="w-full h-full max-w-full max-h-[70vh] overflow-hidden flex items-center justify-center">
                      <canvas
                        id="imageCanvas"
                        className="block object-contain"
                        ref={canvasRef}
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
                            addClasses="border rounded-none text-xl font-bold"
                          >
                            +
                          </Button>
                          <Button
                            onClick={zoomOut}
                            addClasses="border rounded-none text-xl font-bold"
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
                    selectedAlgorithm === "auto_segment_hsv") && (
                    <div className="flex-1 min-w-[260px] p-2">
                      <SegCanvas
                        ref={maskCanvasRef as any}
                        title="HSV Mask"
                        bgClass="bg-fnbg-body"
                        downloadFilename="mask.png"
                      />
                    </div>
                  )}

                  <div className="flex-1 min-w-[260px] p-2">
                    <SegCanvas
                      ref={segmentedCanvasRef as any}
                      title="Segmented Output"
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
