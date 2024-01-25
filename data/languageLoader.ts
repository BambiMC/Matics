import { useEffect, useState } from "react";

export const useLanguageData = (section: string) => {
  const [data, setData] = useState(null);

  useEffect(() => {
    let language =
      localStorage.getItem("lang") ||
      (navigator.language || "en").split("-")[0] ||
      "en";

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
  if (typeof window !== "undefined") {
    let language =
      localStorage.getItem("lang") ||
      (navigator.language || "en").split("-")[0] ||
      "en";

    return language;
  } else {
    return null;
  }
};
