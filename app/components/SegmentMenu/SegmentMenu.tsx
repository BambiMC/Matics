"use client";
import React from "react";
import Button from "@app/components/Button/Button";

type Props = {
  selectedAlgorithm: string | null;
  setSelectedAlgorithm: (s: string | null) => void;
  hMin: number;
  setHMin: (v: number) => void;
  hMax: number;
  setHMax: (v: number) => void;
  sMin: number;
  setSMin: (v: number) => void;
  sMax: number;
  setSMax: (v: number) => void;
  vMin: number;
  setVMin: (v: number) => void;
  vMax: number;
  setVMax: (v: number) => void;
  runAutoSegment: () => void;
  runSegmentHsv: () => void;
  runKMeans: () => void;
  kClusters: number;
  setKClusters: (n: number) => void;
  kCentroids: any[];
  data: Record<string, string> | null;
};

export default function SegmentMenu({
  selectedAlgorithm,
  setSelectedAlgorithm,
  hMin,
  setHMin,
  hMax,
  setHMax,
  sMin,
  setSMin,
  sMax,
  setSMax,
  vMin,
  setVMin,
  vMax,
  setVMax,
  runAutoSegment,
  runSegmentHsv,
  runKMeans,
  kClusters,
  setKClusters,
  kCentroids,
  data,
}: Props) {
  return (
    <>
      {(selectedAlgorithm === "segment_hsv" ||
        selectedAlgorithm === "auto_segment_hsv") && (
        <div className="mt-6 p-4 bg-fnbg-accent">
          <div className="flex items-center justify-between mb-4">
            <h2 className="font-semibold">HSV / Segmentation</h2>
            <div className="flex gap-2">
              <Button
                onClick={() => {
                  setHMin(0);
                  setHMax(179);
                  setSMin(0);
                  setSMax(255);
                  setVMin(0);
                  setVMax(255);
                }}
                addClasses="border rounded-none"
              >
                Reset
              </Button>
            </div>
          </div>
          <div className="grid grid-cols-2 gap-3">
            <label className="text-sm font-medium">
              H min
              <input
                type="number"
                min={0}
                max={179}
                value={hMin}
                onChange={(e) => setHMin(Number(e.target.value))}
                className="w-full border px-2 py-1 bg-fnbg-body"
              />
            </label>
            <label className="text-sm font-medium">
              H max
              <input
                type="number"
                min={0}
                max={179}
                value={hMax}
                onChange={(e) => setHMax(Number(e.target.value))}
                className="w-full border px-2 py-1 bg-fnbg-body"
              />
            </label>
            <label className="text-sm font-medium">
              S min
              <input
                type="number"
                min={0}
                max={255}
                value={sMin}
                onChange={(e) => setSMin(Number(e.target.value))}
                className="w-full border px-2 py-1 bg-fnbg-body"
              />
            </label>
            <label className="text-sm font-medium">
              S max
              <input
                type="number"
                min={0}
                max={255}
                value={sMax}
                onChange={(e) => setSMax(Number(e.target.value))}
                className="w-full border px-2 py-1 bg-fnbg-body"
              />
            </label>
            <label className="text-sm font-medium">
              V min
              <input
                type="number"
                min={0}
                max={255}
                value={vMin}
                onChange={(e) => setVMin(Number(e.target.value))}
                className="w-full border px-2 py-1 bg-fnbg-body"
              />
            </label>
            <label className="text-sm font-medium">
              V max
              <input
                type="number"
                min={0}
                max={255}
                value={vMax}
                onChange={(e) => setVMax(Number(e.target.value))}
                className="w-full border px-2 py-1 bg-fnbg-body"
              />
            </label>
          </div>
          <div className="flex gap-2 mt-4">
            <Button
              onClick={runAutoSegment}
              addClasses="border rounded-none flex-1"
            >
              Auto Segment
            </Button>
            <Button onClick={runSegmentHsv} addClasses="border rounded-none">
              Run HSV Segment
            </Button>
          </div>
        </div>
      )}

      {selectedAlgorithm === "segment_kmeans" && (
        <div className="mt-6 p-4 bg-fnbg-accent">
          <div className="flex gap-2 mt-3 items-center">
            <label className="text-sm">Clusters (k):</label>
            <input
              type="number"
              min={1}
              max={12}
              value={kClusters}
              onChange={(e) => setKClusters(Number(e.target.value))}
              className="w-20 border px-2 py-1"
            />
            <Button onClick={runKMeans} addClasses="border rounded-none">
              Cluster (K-means)
            </Button>
          </div>
          <div className="mt-2">
            <input
              type="range"
              min={1}
              max={12}
              value={kClusters}
              onChange={(e) => setKClusters(Number(e.target.value))}
              className="fnbg-slider w-full"
            />
          </div>
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

          {kCentroids.length > 0 && (
            <div className="mt-3 grid grid-cols-6 gap-2">
              {kCentroids.map((c, i) => (
                <div key={i} className="flex flex-col items-center text-xs">
                  <div
                    style={{
                      width: 36,
                      height: 24,
                      backgroundColor: `rgb(${c.r},${c.g},${c.b})`,
                      border: "1px solid #ccc",
                    }}
                  />
                  <div className="mt-1">#{i + 1}</div>
                </div>
              ))}
            </div>
          )}

          <p className="mt-2 text-xs text-gray-600">
            {data?.["hsvNote"] ??
              "HSV values mimic OpenCV ranges (H: 0-179, S/V: 0-255)."}
          </p>
        </div>
      )}
    </>
  );
}
