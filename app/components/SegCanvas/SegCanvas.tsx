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
            addClasses="rounded-none"
          >
            +
          </Button>
          <Button
            onClick={zoomOut}
            addClasses="rounded-none"
          >
            -
          </Button>
          <div className="ml-auto">
            <Button
              onClick={download}
              addClasses="rounded-none"
              aria-label={downloadFilename || 'Download image'}
            >
              <span className="sr-only">{downloadFilename || 'Download'}</span>
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
    );
  },
);

SegCanvas.displayName = "SegCanvas";

export default SegCanvas;
