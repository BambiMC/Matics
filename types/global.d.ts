// global.d.ts or types/glfx.d.ts
export {};

declare global {
  interface Window {
    fx?: any; // You can make this more specific later
  }
}
