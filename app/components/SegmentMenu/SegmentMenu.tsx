"use client";
import React from "react";
import Button from "@app/components/Button/Button";
import RangeControl from "@app/components/RangeControl/RangeControl";

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
  visibleCentroids?: boolean[];
  toggleCentroid?: (i: number) => void;
  regionHThresh: number;
  setRegionHThresh: (n: number) => void;
  regionSThresh: number;
  setRegionSThresh: (n: number) => void;
  regionVThresh: number;
  setRegionVThresh: (n: number) => void;
  awaitingSeed: boolean;
  setAwaitingSeed: (b: boolean) => void;
  regionConnectivity: 4 | 8;
  setRegionConnectivity: (n: 4 | 8) => void;
  regionMinSize: number;
  setRegionMinSize: (n: number) => void;
  lastSeed: { x: number; y: number } | null;
  runRegionAtSeed: (x?: number, y?: number) => void;
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
  visibleCentroids,
  toggleCentroid,
  regionHThresh,
  setRegionHThresh,
  regionSThresh,
  setRegionSThresh,
  regionVThresh,
  setRegionVThresh,
  awaitingSeed,
  setAwaitingSeed,
  regionConnectivity,
  setRegionConnectivity,
  regionMinSize,
  setRegionMinSize,
  lastSeed,
  runRegionAtSeed,
  data,
}: Props) {
  return (
    <>
      {(selectedAlgorithm === "segment_hsv" ||
        selectedAlgorithm === "auto_segment_hsv") && (
        <div className="mt-6 p-4 bg-fnbg-accent">
          <div className="flex items-center justify-between mb-4">
            <h2 className="font-semibold">{data?.["segment_hsv"]}</h2>
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
                {data?.["reset"]}
              </Button>
            </div>
          </div>
          <div className="grid grid-cols-2 gap-3">
            <RangeControl
              label="H min"
              value={hMin}
              onChange={setHMin}
              min={0}
              max={179}
              step={1}
              inputType="number"
            />
            <RangeControl
              label="H max"
              value={hMax}
              onChange={setHMax}
              min={0}
              max={179}
              step={1}
              inputType="number"
            />
            <RangeControl
              label="S min"
              value={sMin}
              onChange={setSMin}
              min={0}
              max={255}
              step={1}
              inputType="number"
            />
            <RangeControl
              label="S max"
              value={sMax}
              onChange={setSMax}
              min={0}
              max={255}
              step={1}
              inputType="number"
            />
            <RangeControl
              label="V min"
              value={vMin}
              onChange={setVMin}
              min={0}
              max={255}
              step={1}
              inputType="number"
            />
            <RangeControl
              label="V max"
              value={vMax}
              onChange={setVMax}
              min={0}
              max={255}
              step={1}
              inputType="number"
            />
          </div>
          <div className="flex gap-2 mt-4">
            <Button
              onClick={runAutoSegment}
              addClasses="border rounded-none flex-1 opacity-20"
            >
              {data?.["auto_segment"]}
            </Button>
            <Button onClick={runSegmentHsv} addClasses="border rounded-none">
              {data?.["run_hsv"]}
            </Button>
          </div>
        </div>
      )}

      {selectedAlgorithm === "segment_kmeans" && (
        <div className="mt-6 p-4 bg-fnbg-accent">
          <div className="flex mt-3 items-center gap-2">
            <div className="flex items-center gap-2 w-1/2">
              <label className="text-sm">{data?.["clusters_k"]}:</label>
              <RangeControl
                label=""
                value={kClusters}
                onChange={setKClusters}
                min={1}
                max={12}
                step={1}
                inputType="number"
                className="w-20 border px-2 py-1"
              />
            </div>
            <div className="flex justify-end w-1/2">
              <Button onClick={runKMeans} addClasses="border rounded-none">
                {data?.["cluster_k_means"]}
              </Button>
            </div>
          </div>

          <div className="mt-2">
            {/* use shared RangeControl for the kClusters slider */}
            <input
              type="range"
              min={1}
              max={12}
              value={kClusters}
              onChange={(e) => setKClusters(Number(e.target.value))}
              className="fnbg-slider w-full"
            />
          </div>

          {kCentroids.length > 0 && (
            <div className="mt-3 grid grid-cols-6 gap-2">
              {kCentroids.map((c, i) => {
                const hidden = visibleCentroids ? !visibleCentroids[i] : false;
                return (
                  <button
                    key={i}
                    onClick={() => toggleCentroid && toggleCentroid(i)}
                    className="flex flex-col items-center text-xs focus:outline-none"
                    style={{ opacity: 1 }}
                  >
                    <div
                      style={{
                        width: 36,
                        height: 24,
                        backgroundColor: `rgb(${c.r},${c.g},${c.b})`,
                        border: "1px solid #ccc",
                        cursor: "pointer",
                      }}
                    />
                    <div className="mt-1">#{i + 1}</div>
                  </button>
                );
              })}
            </div>
          )}
        </div>
      )}

      {selectedAlgorithm === "segment_region" && (
        <div className="mt-6 p-4 bg-fnbg-accent">
          <div className="flex items-center justify-between mb-4">
            <h2 className="font-semibold">{data?.["region_grow_seed"]}</h2>
            <div className="flex gap-2">
              <Button
                onClick={() => {
                  setRegionHThresh(15);
                  setRegionSThresh(50);
                  setRegionVThresh(50);
                }}
                addClasses="border rounded-none"
              >
                {data?.["reset"]}
              </Button>
            </div>
          </div>

          <div className="grid grid-cols-2 gap-3">
            <RangeControl
              label={data?.["region_h_threshold"] ?? "H threshold"}
              value={regionHThresh}
              onChange={setRegionHThresh}
              min={0}
              max={179}
              step={1}
              inputType="number"
            />
            <RangeControl
              label={data?.["region_s_threshold"] ?? "S threshold"}
              value={regionSThresh}
              onChange={setRegionSThresh}
              min={0}
              max={255}
              step={1}
              inputType="number"
            />
            <RangeControl
              label={data?.["region_v_threshold"] ?? "V threshold"}
              value={regionVThresh}
              onChange={setRegionVThresh}
              min={0}
              max={255}
              step={1}
              inputType="number"
            />
            <label className="text-sm font-medium">
              {data?.["connectivity"] ?? "Connectivity"}:
              <select
                value={regionConnectivity}
                onChange={(e) =>
                  setRegionConnectivity(Number(e.target.value) as 4 | 8)
                }
                className="w-full border px-2 py-1 bg-fnbg-body"
              >
                <option value={4}>
                  {data?.["4_connected"] ?? "4-connected"}
                </option>
                <option value={8}>
                  {data?.["8_connected"] ?? "8-connected"}
                </option>
              </select>
            </label>
            <RangeControl
              label={data?.["min_size"] ?? "Min size"}
              value={regionMinSize}
              onChange={setRegionMinSize}
              min={1}
              max={1000000}
              step={1}
              inputType="number"
            />
          </div>

          <div className="flex gap-2 mt-4">
            <Button
              onClick={() => setAwaitingSeed(true)}
              addClasses="border rounded-none flex-1"
            >
              {awaitingSeed
                ? (data?.["click_on_image"] ?? "Click on image...")
                : (data?.["select_seed"] ?? "Select Seed")}
            </Button>
            <Button
              onClick={() => runRegionAtSeed()}
              addClasses="border rounded-none"
              disabled={!lastSeed}
            >
              {data?.["run_region_grow"] ?? "Run Region Grow"}
            </Button>
            <p className="ml-2 self-center text-sm text-gray-600">
              {lastSeed
                ? `${data?.["last_seed"] ?? "Last seed"}: (${lastSeed.x}, ${lastSeed.y})`
                : (data?.["no_seed_yet"] ?? "No seed yet")}
            </p>
          </div>
        </div>
      )}
    </>
  );
}
