import { useEffect, useState } from "react";

export const useLanguageData = (section: string) => {
  const [data, setData] = useState(null);

  useEffect(() => {
    const lang = localStorage.getItem("lang");
    const language = lang || "en";

    import(`./${language}.json`)
      .then((importedData) => {
        if (importedData[section]) {
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
