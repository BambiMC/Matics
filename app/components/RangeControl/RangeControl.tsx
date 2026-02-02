"use client";
import React from "react";

type Props = {
  label: string;
  value: number;
  onChange: (v: number) => void;
  min: number;
  max: number;
  step?: number;
  id?: string;
  className?: string;
  inputType?: "range" | "number";
};

export default function RangeControl({
  label,
  value,
  onChange,
  min,
  max,
  step = 1,
  id,
  className = "",
  inputType = "range",
}: Props) {
  return (
    <label className="w-full">
      <div className="flex items-center justify-between">
        <span className="inline-block text-sm">{label}</span>
      </div>
      <input
        id={id}
        className={`w-full bg-fnbg-body ${inputType === "range" ? "fnbg-slider" : ""} ${className}`}
        type={inputType}
        min={String(min)}
        max={String(max)}
        step={String(step)}
        value={value}
        onChange={(e) => onChange(Number(e.target.value))}
      />
    </label>
  );
}
