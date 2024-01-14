import { useEffect, useState } from "react";

export const useLanguageData = (section: string) => {
  const [data, setData] = useState(null);

  useEffect(() => {
    const lang = localStorage.getItem("lang");
    const language = lang || "en";

    import(`./${language}.json`)
      .then((importedData) => {
        if (importedData[section]) {
          console.log(importedData[section]);
          setData(importedData[section]);
        } else {
          console.error(`Section "${section}" not found in the JSON data.`);
        }
      })
      .catch((error) => {
        console.error(error);
      });
  }, [section]);

  return data;
};

export const useLang = () => {
  // Check if window (client side) is defined
  if (typeof window !== "undefined") {
    const lang = localStorage.getItem("lang");
    return lang;
  } else {
    // Handle the case when running on the server side (if needed)
    return null;
  }
};
