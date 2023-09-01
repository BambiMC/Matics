import { useEffect, useState } from "react";

export const useLanguageData = () => {
  const [data, setData] = useState(null);

  useEffect(() => {
    const lang = localStorage.getItem("lang");
    const language = lang || "en";

    import(`./${language}.json`)
      .then((importedData) => {
        console.log(importedData);
        setData(importedData);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return data;
};
