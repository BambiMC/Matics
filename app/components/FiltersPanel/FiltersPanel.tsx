"use client";
import React from "react";
import Button from "@app/components/Button/Button";

type Props = {
  contrast: number;
  setContrast: (v: number) => void;
  sharpen: number;
  setSharpen: (v: number) => void;
  noise: number;
  setNoise: (v: number) => void;
  hue: number;
  setHue: (v: number) => void;
  histogramMinValue: number;
  setHistogramMinValue: (v: number) => void;
  histogramMaxValue: number;
  setHistogramMaxValue: (v: number) => void;
  generateHistogram: () => void;
  data: Record<string, string> | null;
  resetFilters: () => void;
  showOriginal: boolean;
  toggleShowOriginal: () => void;
};

export default function FiltersPanel({
  contrast,
  setContrast,
  sharpen,
  setSharpen,
  noise,
  setNoise,
  hue,
  setHue,
  histogramMinValue,
  setHistogramMinValue,
  histogramMaxValue,
  setHistogramMaxValue,
  generateHistogram,
  data,
  resetFilters,
  showOriginal,
  toggleShowOriginal,
}: Props) {
  return (
    <>
      <label>
        {data?.["contrast"] ?? "Contrast"}: {contrast.toFixed(2)}
        <input
          className="w-full fnbg-slider"
          type="range"
          min="0"
          max="3"
          step="0.01"
          value={contrast}
          onChange={(e) => setContrast(Number(e.target.value))}
        />
      </label>

      <label>
        {data?.["sharpness"] ?? "Sharpness"}: {sharpen.toFixed(2)}
        <input
          className="w-full fnbg-slider"
          type="range"
          min="0"
          max="1"
          step="0.01"
          value={sharpen}
          onChange={(e) => setSharpen(Number(e.target.value))}
        />
      </label>

      <label>
        {data?.["noise"] ?? "Noise"}: {noise.toFixed(2)}
        <input
          className="w-full fnbg-slider"
          type="range"
          min="0"
          max="1"
          step="0.01"
          value={noise}
          onChange={(e) => setNoise(Number(e.target.value))}
        />
      </label>

      <label>
        {data?.["hue"] ?? "Hue"}: {hue.toFixed(0)}°
        <input
          className="w-full fnbg-slider"
          type="range"
          min="-180"
          max="180"
          step="1"
          value={hue}
          onChange={(e) => setHue(Number(e.target.value))}
        />
      </label>
      <div className="flex gap-2 mt-4">
        <Button
          onClick={resetFilters}
          addClasses="border border-fnbg-purple rounded-none"
        >
          {data?.["resetFilters"] ?? "Reset Filters"}
        </Button>
        <Button
          onClick={toggleShowOriginal}
          addClasses="border border-fnbg-purple rounded-none"
        >
          {showOriginal
            ? (data?.["showModifiedVersion"] ?? "Show Modified")
            : (data?.["showOriginal"] ?? "Show Original")}
        </Button>
      </div>
      <hr className="border border-fnbg-orange my-4" />
      <div className="flex items-center flex-wrap gap-2">
        <span className="font-bold mr-20">
          {data?.["histogramLimits"] ?? "Histogram limits"}
        </span>
        <input
          type="number"
          min="0"
          max="255"
          step="1"
          value={histogramMinValue}
          onChange={(e) => setHistogramMinValue(Number(e.target.value))}
          className="w-16 border border-gray-300 rounded px-2"
        />
        <span>-</span>
        <input
          type="number"
          min="0"
          max="255"
          step="1"
          value={histogramMaxValue}
          onChange={(e) => setHistogramMaxValue(Number(e.target.value))}
          className="w-16 border border-gray-300 rounded px-2"
        />
        <Button
          onClick={generateHistogram}
          addClasses="border border-fnbg-purple rounded-none "
        >
          {data?.["generateBrightnessHistogram"] ?? "Generate Histogram"}
        </Button>
      </div>

      <canvas id="histogramCanvas" className="mt-2"></canvas>
      <style jsx>{`
        .fnbg-slider {
          -webkit-appearance: none;
          appearance: none;
          height: 8px;
          border-radius: 9999px;
          background: linear-gradient(
            90deg,
            #3b82f6,
            var(--fnbg-orange, #fb923c)
          );
          outline: none;
        }
        .fnbg-slider::-webkit-slider-runnable-track {
          height: 8px;
          border-radius: 9999px;
          background: transparent;
        }
        .fnbg-slider::-webkit-slider-thumb {
          -webkit-appearance: none;
          appearance: none;
          width: 18px;
          height: 18px;
          border-radius: 50%;
          background: #fff;
          border: 2px solid rgba(0, 0, 0, 0.15);
          margin-top: -5px;
        }
        .fnbg-slider::-moz-range-track {
          height: 8px;
          border-radius: 9999px;
          background: transparent;
        }
        .fnbg-slider::-moz-range-thumb {
          width: 18px;
          height: 18px;
          border-radius: 50%;
          background: #fff;
          border: 2px solid rgba(0, 0, 0, 0.15);
        }
      `}</style>
    </>
  );
}
