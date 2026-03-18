"use client";
import React from "react";
import Button from "@app/components/Button/Button";
import RangeControl from "@app/components/RangeControl/RangeControl";

type Props = {
  contrast: number;
  setContrast: (v: number) => void;
  sharpen: number;
  setSharpen: (v: number) => void;
  blur: number;
  setBlur: (v: number) => void;
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
  blur,
  setBlur,
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
      <RangeControl
        label={data?.["contrast"] ?? "Contrast"}
        value={contrast}
        onChange={setContrast}
        min={0}
        max={3}
        step={0.01}
      />

      <RangeControl
        label={data?.["sharpness"] ?? "Sharpness"}
        value={sharpen}
        onChange={setSharpen}
        min={0}
        max={1}
        step={0.01}
      />

      <RangeControl
        label={data?.["blur"] ?? "Blur"}
        value={blur}
        onChange={setBlur}
        min={0}
        max={50}
        step={1}
      />

      <RangeControl
        label={data?.["noise"] ?? "Noise"}
        value={noise}
        onChange={setNoise}
        min={0}
        max={1}
        step={0.01}
      />

      <RangeControl
        label={data?.["hue"] ?? "Hue"}
        value={hue}
        onChange={setHue}
        min={-180}
        max={180}
        step={1}
      />
      <div className="flex gap-2 mt-4">
        <Button
          onClick={resetFilters}
          addClasses="rounded-none"
        >
          {data?.["resetFilters"] ?? "Reset Filters"}
        </Button>
        <Button
          onClick={toggleShowOriginal}
          addClasses="rounded-none"
        >
          {showOriginal
            ? (data?.["showModifiedVersion"] ?? "Show Modified")
            : (data?.["showOriginal"] ?? "Show Original")}
        </Button>
      </div>
      <hr className="my-4" />
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
          className="w-16 rounded px-2"
        />
        <span>-</span>
        <input
          type="number"
          min="0"
          max="255"
          step="1"
          value={histogramMaxValue}
          onChange={(e) => setHistogramMaxValue(Number(e.target.value))}
          className="w-16 rounded px-2"
        />
        <Button
          onClick={generateHistogram}
          addClasses="rounded-none "
        >
          {data?.["generateBrightnessHistogram"] ?? "Generate Histogram"}
        </Button>
      </div>

      <canvas id="histogramCanvas" className="mt-2"></canvas>
    </>
  );
}
