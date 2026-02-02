"use client";
import React, {
  forwardRef,
  useImperativeHandle,
  useRef,
  useState,
} from "react";
import Button from "@app/components/Button/Button";

type Props = {
  title: string;
  bgClass?: string;
  downloadFilename?: string;
  canvasClassName?: string;
};

const SegCanvas = forwardRef<HTMLCanvasElement, Props>(
  (
    {
      title,
      bgClass = "bg-amber-500",
      downloadFilename = "image.png",
      canvasClassName = "",
    },
    ref,
  ) => {
    const localRef = useRef<HTMLCanvasElement | null>(null);
    const [scale, setScale] = useState(1);

    useImperativeHandle(ref, () => localRef.current as HTMLCanvasElement);

    const zoomIn = () => setScale((s) => Math.min(s + 0.1, 5));
    // Prevent zooming out below 100% (scale 1)
    const zoomOut = () => setScale((s) => Math.max(s - 0.1, 1));

    const download = () => {
      if (!localRef.current) return;
      const link = document.createElement("a");
      link.download = downloadFilename;
      try {
        link.href = localRef.current.toDataURL("image/png");
        link.click();
      } catch (e) {
        console.error("Failed to download canvas", e);
      }
    };

    return (
      <div className="flex flex-col h-full">
        <p className="font-semibold mb-1">{title}</p>
        <div style={{ overflow: "auto" }} className="flex-1 min-h-[140px]">
          <canvas
            ref={localRef}
            className={`w-full ${bgClass} ${canvasClassName}`}
            style={{
              transform: `scale(${scale})`,
              transformOrigin: "top left",
              display: "block",
              minHeight: 120,
            }}
          />
        </div>
        <div className="flex mt-4 gap-2 p-4 bg-fnbg-accent ">
          <Button
            onClick={zoomIn}
            addClasses="border border-fnbg-purple rounded-none"
          >
            +
          </Button>
          <Button
            onClick={zoomOut}
            addClasses="border border-fnbg-purple rounded-none"
          >
            -
          </Button>
          <div className="ml-auto">
            <Button
              onClick={download}
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
    );
  },
);

SegCanvas.displayName = "SegCanvas";

export default SegCanvas;
