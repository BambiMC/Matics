"use client"

import { useLanguageData } from "@data/languageLoader";
import Link from "next/link";

const Imprint: React.FC = () => {

    const data = useLanguageData("alienDino");

    return (
        <main className="container mx-auto my-32 px-32">
            {data && (
                <div className="container mx-auto px-4">
                    <h1 className="text-4xl font-bold mb-8">VSCode Theme - Alien Dino</h1>

                    <p>
                        {'How would a dino look like if it was an angry?'}
                    </p>
                    <p>
                        {'Obviously it is a dark theme, but it is not just a dark theme.'}
                    </p>
                    <p>
                        {'Since everyone knows that an alien dino would have an orange and purple stripes, thats a given, but of course thats not all.'}
                    </p>
                    <p>
                        {'There are also some other colors which you can explore. ^^'}
                    </p>
                    <p>
                        {'And that is exactly what this theme is about.'}
                    </p>
                    <p>
                        {'Enjoy! (ofc it\'s free)'}
                    </p>

                    <p className="my-8">
                        <Link href={"https://marketplace.visualstudio.com/items?itemName=FabianBerger.alien-dino"}>
                            VSCode Marketplace Link
                        </Link>
                    </p>

                    <img src="/path/to/your/image.jpg" alt="Alien Dino Image" className="my-8" />
                    <img src="/path/to/your/image.jpg" alt="Alien Dino Image" className="my-8" />
                    <img src="/path/to/your/image.jpg" alt="Alien Dino Image" className="my-8" />
                    <img src="/path/to/your/image.jpg" alt="Alien Dino Image" className="my-8" />
                    <img src="/path/to/your/image.jpg" alt="Alien Dino Image" className="my-8" />

                </div>
            )}
        </main>
    );
};

export default Imprint;