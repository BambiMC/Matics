import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  darkMode: ["class"],
  theme: {
    extend: {
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },
      gridTemplateColumns: {
        "18": "repeat(18, minmax(0, 1fr))",
      },
      gridColumnStart: {
        "13": "13",
        "14": "14",
        "15": "15",
        "16": "16",
        "17": "17",
        "18": "18",
      },
      maxWidth: {
        "9xl": "2000px",
      },
      colors: {
        "fnbg-purple": "var(--fnbg-purple)",
        "fnbg-orange": "var(--fnbg-orange)",
        "fnbg-body": "var(--fnbg-body)",
        "fnbg-accent": "var(--fnbg-accent)",
      },
    },
  },
  plugins: [],
};
export default config;
