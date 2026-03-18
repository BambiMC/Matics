"use client";
import React, { useRef, useState, useEffect } from "react";
import dynamic from "next/dynamic";
import Button from "@app/components/Button/Button";
import * as imageProcessing from "@lib/imageProcessing";
import { useLanguageData } from "@data/languageLoader";



const Projects: React.FC = () => {
  const fileInputRef = useRef<HTMLInputElement | null>(null);
  const canvasRef = useRef<HTMLCanvasElement | null>(null);

  const [imageSrc, setImageSrc] = useState<string | null>(null);
  const [originalImageSrc, setOriginalImageSrc] = useState<string | null>(null);

  const [contrast, setContrast] = useState(1);
  const [sharpen, setSharpen] = useState(0);
  const [noise, setNoise] = useState(0);
  const [hue, setHue] = useState(0);

  const [histogramMinValue, setHistogramMinValue] = useState(0);
  const [histogramMaxValue, setHistogramMaxValue] = useState(255);

  const [scale, setScale] = useState(1);
  const zoomIn = () => setScale(prev => Math.min(prev + 0.1, 5));
  const zoomOut = () => setScale(prev => Math.max(prev - 0.1, 0.1));

  const [showOriginal, setShowOriginal] = useState(false);

  const [appliedAlgorithms, setAppliedAlgorithms] = useState<string[]>([]);





  const resetFilters = () => {
    setContrast(1);
    setSharpen(0);
    setNoise(0);
    setHue(0);
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
      "/exampleImages/xray1.png",
      "/exampleImages/xray2.jpg",
      "/exampleImages/xray3.jpg",
      "/exampleImages/xray4.png",
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


  useEffect(() => {
    if (!imageSrc || !canvasRef.current) return;

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
            const safeContrast = isNaN(contrast) ? 1 : Math.max(0, Math.min(3, contrast));
            const safeSharpen = Math.max(0, Math.min(1, sharpen));
            const safeNoise = Math.max(0, Math.min(1, noise));
            const safeHue = Math.max(-180, Math.min(180, hue)) / 360; // Normalize to -0.5 ~ 0.5

            // Apply all GPU-based filters in order
            if (safeContrast !== 1) fxCanvas = fxCanvas.brightnessContrast(0, safeContrast - 1);
            if (safeHue !== 0) fxCanvas = fxCanvas.hueSaturation(safeHue, 0);
            if (safeSharpen > 0) fxCanvas = fxCanvas.unsharpMask(20, safeSharpen * 2);
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

          if (appliedAlgorithms.length > 0 && !showOriginal) {
            //go through the appliedAlgorithm list and apply each algorithm
            appliedAlgorithms.forEach((algorithm) => {
              if (algorithm === 'algorithm1') {
                imageProcessing.floodBackground(tempCanvas);
                imageProcessing.stretchBrightnessContrast(tempCanvas);
              } else if (algorithm === 'algorithm2') {
                imageProcessing.stretchBrightnessContrast(tempCanvas, true);
              }
              else if (algorithm === 'algorithm3') {
                imageProcessing.focus_on_grey(tempCanvas);
              }
            });
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
        } catch (error) {
          console.error("Error during glfx image processing:", error);
        }
      };

      img.onerror = () => {
        console.error("Failed to load image for processing");
      };
    });
  }, [imageSrc, sharpen, noise, contrast, hue, appliedAlgorithms, showOriginal]);





  const data = useLanguageData("xray");

  return (
    <main className="px-4 mx-auto w-screen max-w-9xl my-40 md:mt-20 lg:mt-24">
      {data && (
        <div>
          <h1 className="font-bold text-2xl my-4">{data['title']}</h1>

          <div className="my-4 p-4 bg-fnbg-accent">
            <div className="flex flex-wrap items-center">
              <input type="file" accept="image/*" ref={fileInputRef} onChange={handleFileChange} className="hidden" aria-label="Upload Image" />
              <Button onClick={handleButtonClick} addClasses="mx-2 mr-4">{data['upload']}</Button>
              <Button onClick={() => loadExampleImage(0)} addClasses="mx-2">{data['example1']}</Button>
              <Button onClick={() => loadExampleImage(1)} addClasses="mx-2">{data['example2']}</Button>
              <Button onClick={() => loadExampleImage(2)} addClasses="mx-2">{data['example3']}</Button>
            </div>
            <div className="flex mt-4 mx-2 gap-4">
              <Button onClick={() => setAppliedAlgorithms([...appliedAlgorithms, 'algorithm1'])} addClasses={``}>{data['algorithm1']}</Button>
              <Button onClick={() => {
                setAppliedAlgorithms([...appliedAlgorithms, 'algorithm2'])
              }} addClasses={``}>{data['algorithm2']}</Button>
              <Button onClick={() => {
                setAppliedAlgorithms([...appliedAlgorithms, 'algorithm3'])
              }} addClasses={``}>{data['algorithm3']}</Button>

            </div>
          </div>

          {imageSrc && (
            <div className="mt-6 flex gap-8 flex-wrap">

              {/* Left Column: Filters and Controls */}
              <div className="flex flex-col gap-4 w-full md:w-1/2 max-w-md">
                <label>
                  {data['contrast']}: {contrast.toFixed(2)}
                  <input
                    className="w-full"
                    type="range"
                    min="0"
                    max="3"
                    step="0.01"
                    value={contrast}
                    onChange={(e) => setContrast(Number(e.target.value))}
                  />
                </label>

                <label>
                  {data['sharpness']}: {sharpen.toFixed(2)}
                  <input
                    className="w-full"
                    type="range"
                    min="0"
                    max="1"
                    step="0.01"
                    value={sharpen}
                    onChange={(e) => setSharpen(Number(e.target.value))}
                  />
                </label>

                <label>
                  {data['noise']}: {noise.toFixed(2)}
                  <input
                    className="w-full"
                    type="range"
                    min="0"
                    max="1"
                    step="0.01"
                    value={noise}
                    onChange={(e) => setNoise(Number(e.target.value))}
                  />
                </label>

                <label>
                  {data['hue']}: {hue.toFixed(0)}°
                  <input
                    className="w-full"
                    type="range"
                    min="-180"
                    max="180"
                    step="1"
                    value={hue}
                    onChange={(e) => setHue(Number(e.target.value))}
                  />
                </label>
                <hr className="border border-fnbg-orange my-4" />
                <div className="flex items-center flex-wrap gap-4">

                  <span className="font-bold">{data['histogramLimits']}</span>
                  <input
                    type="number"
                    min="0"
                    max="255"
                    step="1"
                    value={histogramMinValue}
                    onChange={(e) => setHistogramMinValue(Number(e.target.value))}
                    className="w-20 border border-gray-300 rounded px-2"
                    title="Begrenzung für minimale Helligkeit"
                  />
                  <span>-</span>
                  <input
                    type="number"
                    min="0"
                    max="255"
                    step="1"
                    value={histogramMaxValue}
                    onChange={(e) => setHistogramMaxValue(Number(e.target.value))}
                    className="w-20 border border-gray-300 rounded px-2"
                    title="Begrenzung für maximale Helligkeit"
                  />
                  <Button
                    onClick={() => imageProcessing.generateHistogram(histogramMinValue, histogramMaxValue)}
                    addClasses=""
                  >
                    {data['generateBrightnessHistogram']}
                  </Button>
                </div>

                <canvas id="histogramCanvas" className="mt-2"></canvas>
              </div>

              <div className="flex flex-col gap-4 w-full md:w-1/2">
                <div
                  className="resize overflow-auto border max-w-full max-h-[90vh] relative"
                  style={{
                    minWidth: '300px',
                    minHeight: '300px',
                  }}
                >
                  <canvas
                    id="imageCanvas"
                    className="w-full h-full object-contain "
                    ref={canvasRef}
                    style={{
                      transform: `scale(${scale})`,
                      transformOrigin: 'top left',
                      display: 'block',
                    }}
                  />
                </div>

                <div className="flex mt-4 gap-2 p-4 bg-fnbg-accent">
                  <Button onClick={resetFilters} addClasses="">
                    {data['resetFilters']}
                  </Button>
                  <Button
                    onClick={() => setShowOriginal(prev => !prev)}
                    addClasses=""
                  >
                    {showOriginal ? data['showModifiedVersion'] : data['showOriginal']}
                  </Button>
                  <Button onClick={zoomIn} addClasses=" text-xl font-bold">+</Button>
                  <Button onClick={zoomOut} addClasses=" text-xl font-bold">-</Button>

                  <div className="ml-auto fnbg">
                    <Button onClick={handleDownload} aria-label={data['download'] || 'Download image'}>
                      <span className="sr-only">{data['download'] || 'Download'}</span>
                      <span
                        className="w-6 h-6 inline-block bg-fnbg-text"
                        role="img"
                        aria-hidden="true"
                        style={{
                          WebkitMaskImage: `url(../imgs/dl_icon.png)`,
                          WebkitMaskSize: 'contain',
                          WebkitMaskRepeat: 'no-repeat',
                          WebkitMaskPosition: 'center',
                          maskImage: `url(../imgs/dl_icon.png)`,
                          maskSize: 'contain',
                          maskRepeat: 'no-repeat',
                          maskPosition: 'center',
                        }}
                      />
                    </Button>
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