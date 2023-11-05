"use client"

import { useLanguageData } from "@data/languageLoader";

const Imprint: React.FC = () => {

  const data = useLanguageData("imprint");

  return (
    <main className="container mx-auto my-32 px-32">
      {data && (
        <div className="container mx-auto px-4">
          <h1 className="text-4xl font-bold mb-8">{data['title']}</h1>

          <section className="mb-8">
            <h2 className="text-xl font-semibold mb-2">{data['tmg']}</h2>
            <address className="text-lg">
              Fabian Berger<br />
              Jenaer Straße 1<br />
              91058 Erlangen
            </address>
          </section>

          <section className="mb-8">
            <h2 className="text-xl font-semibold mb-2">{data['contact']}</h2>
            <p className="text-lg">
              {data['telephone']}: 0151 53924940<br />
            </p>
            <p className="text-lg">
              E-Mail: <a href="mailto:me@fnbg.de">me@fnbg.de</a>
            </p>
          </section>

          <section className="mb-8">
            <h2 className="text-xl font-semibold mb-2">{data['editorial']}</h2>
            <p className="text-lg">Fabian Berger</p>
          </section>

          <section className="mb-8">
            <h2 className="text-xl font-semibold mb-2">{data['rstv']}:</h2>
            <p className="text-lg">
              Fabian Berger<br />
              Jenaer Straße 1<br />
              91058 Erlangen
            </p>
          </section>

          <section className="mb-8">
            <h2 className="text-xl font-semibold mb-2">{data['disclaimer']}:</h2>
            <h3 className="text-lg font-semibold mb-2">{data['liability1']}</h3>
            <p className="text-lg">
              {data['liabilityText1']}
            </p>
          </section>

          <section className="mb-8">
            <h3 className="text-xl font-semibold mb-2">{data['liability2']}:</h3>
            <p className="text-lg">
              {data['liabilityText2']}
            </p>
          </section>

          <section className="mb-8">
            <h3 className="text-xl font-semibold mb-2">{data['liability3']}:</h3>
            <p className="text-lg">
              {data['liabilityText3']}
            </p>
          </section>

          <section className="mb-8">
            <h3 className="text-xl font-semibold mb-2">{data['liability4']}:</h3>
            <p className="text-lg">
              {data['liabilityText4']}
            </p>
          </section>

          <section className="mb-8">
            <h3 className="text-xl font-semibold mb-2">{data['liability5']}:</h3>
            <p className="text-lg">
              {data['liabilityText5']}
            </p>
          </section>
        </div>
      )}
    </main>
  );
};

export default Imprint;
