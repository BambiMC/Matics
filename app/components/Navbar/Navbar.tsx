//TODO Lebenslauf neu machen
"use client"
import Link from 'next/link';
import Image from 'next/image';
import { ThemeSwitcher } from '../ThemeSwitcher/ThemeSwitcher';
import { useLanguageData } from '@data/languageLoader';
import Button from '../Button/Button';

const toggleMobileMenu = () => {
  console.log('Toggle mobile menu clicked');
  const mobileMenu = document.getElementById('mobile-menu');
  mobileMenu?.classList.toggle('hidden');
};

const toggleLangMenu = () => {
  console.log('Toggle Language menu clicked');
  const langMenu = document.getElementById('lang-menu');
  langMenu?.classList.toggle('hidden');
};

const reload = () => {
  window.location.reload();
};

const handleLangButtonClick = (selectedLang: string) => {
  localStorage.setItem('lang', selectedLang);
  reload();
};

const Navbar = () => {
  const data = useLanguageData("navbar");

  return (
    <nav className="px-4 py-1 z-20 fixed w-full">
      {data && (
        <div>
          <div className="flex items-center justify-between">
            <Link href="/">
              <Image className="h-16 max-w-xs min-w-xs" src="/svg/fnbg-logo8.svg" alt="" id="logo" width={109} height={64} />
            </Link>
            <div className="hidden gap-2 lg:flex items-center">
              <Link href="https://blog.fnbg.de" target="_blank" className="px-5 py-3">{data['blog']}</Link>
              <Link href="/Lebenslauf-Fabian-Berger.pdf" className="px-5 py-3" target="_blank">{data['resume']}</Link>
              <Link href="/projects" className="px-5 py-3">{data['projects']}</Link>
              <a href="mailto:me@fnbg.de" className='px-5 py-3 self-center'>me@fnbg.de</a>
              <Link href="https://www.linkedin.com/in/fabian-berger-nbg/" className="px-5 py-3" target="_blank">{data['linkedin']}</Link>
              <Link href="/imprint" className="px-5 py-3">{data['imprint']}</Link>
            </div>
            <div className='flex px-2'>
              <Button addClasses='hidden xl:block' onClick={() => handleLangButtonClick('en')}>EN</Button>
              <Button addClasses='hidden xl:block' onClick={() => handleLangButtonClick('de')}>DE</Button>
              <Button addClasses='hidden xl:block' onClick={() => handleLangButtonClick('es')}>ES</Button>
              <Button addClasses='hidden xl:block' onClick={() => handleLangButtonClick('fr')}>FR</Button>
              <Button addClasses='hidden xl:block pr-8' onClick={() => handleLangButtonClick('jp')}>JP</Button>
              <button onClick={toggleLangMenu} className='xl:hidden px-3 text-fnbg-purple'>
                <svg
                  height="32"
                  width="32"
                  viewBox="0 0 15.304 15.304"
                  strokeWidth="0"
                  fill="currentColor"
                  id='lang-icon'
                >
                  <path d="M5.734,8.248V7.617C5.382,7.377,5.049,7.092,4.742,6.754c-0.889,0.859-1.74,1.403-1.836,1.464
        L2.825,8.268l-0.49-0.783l0.08-0.051c0.01-0.007,0.876-0.556,1.751-1.413C3.363,4.85,3.054,3.67,3.042,3.619l-0.023-0.09
        l0.895-0.23L3.936,3.39C3.938,3.4,4.193,4.344,4.813,5.316c0.613-0.745,0.97-1.463,1.061-2.14H2.115V2.171h2.072V1.612h0.966
        v0.558h2.072v1.006H6.808C6.711,4.117,6.233,5.092,5.384,6.077c0.114,0.128,0.231,0.245,0.35,0.357V6.369V5.961
        c0-0.336,0.272-0.608,0.608-0.608h2.705V0.569c0-0.084-0.067-0.152-0.152-0.152H0.152C0.068,0.417,0,0.485,0,0.569v8.742
        c0,0.085,0.068,0.152,0.152,0.152h5.582L5.734,8.248L5.734,8.248z"/>
                  <path d="M10.728,8.515h-0.017c-0.084,0.333-0.166,0.755-0.258,1.078l-0.332,1.187h1.236L11.01,9.593
        C10.91,9.261,10.81,8.847,10.728,8.515z"/>
                  <path d="M15.152,5.841H6.41c-0.084,0-0.152,0.068-0.152,0.152v8.743c0,0.084,0.068,0.151,0.152,0.151
        h8.742c0.085,0,0.152-0.067,0.152-0.151V5.993C15.304,5.91,15.237,5.841,15.152,5.841z M11.972,13.16l-0.431-1.436H9.94
        L9.541,13.16h-1.31L9.94,7.57h1.658l1.733,5.59H11.972z"/>
                  <polygon points="3.935,9.846 2.72,9.846 2.72,11.866 3.726,12.862 5.986,12.862 5.986,11.647 
        3.935,11.647 			"/>
                </svg>

              </button>
              <ThemeSwitcher />
              <button
                className="inline px-2 py-3 lg:hidden"
                onClick={toggleMobileMenu}
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  className="icon icon-tabler icon-tabler-menu-2"
                  width="32"
                  height="32"
                  viewBox="0 0 24 24"
                  strokeWidth="2"
                  stroke="currentColor"
                  strokeLinecap="round"
                  strokeLinejoin="round"
                >
                  <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                  <line x1="4" y1="6" x2="20" y2="6"></line>
                  <line x1="4" y1="12" x2="20" y2="12"></line>
                  <line x1="4" y1="18" x2="20" y2="18"></line>
                </svg>
              </button>
            </div>
          </div>
          <div className='px-2 hidden xl:hidden' id='lang-menu'>
            <div className="absolute top-20 right-2 border rounded border-gray-300 flex flex-row">
              <Button onClick={() => handleLangButtonClick('en')}>EN</Button>
              <Button onClick={() => handleLangButtonClick('de')}>DE</Button>
              <Button onClick={() => handleLangButtonClick('es')}>ES</Button>
              <Button onClick={() => handleLangButtonClick('fr')}>FR</Button>
              <Button onClick={() => handleLangButtonClick('jp')}>JP</Button>
            </div>
          </div>
          <div className="order-last hidden lg:hidden" id="mobile-menu">
            <div className="flex flex-row flex-wrap">
              <Link href="https://blog.fnbg.de" target="_blank" className="px-5 py-3">{data['blog']}</Link>
              <Link href="/Lebenslauf-Fabian-Berger.pdf" className="px-5 py-3" target="_blank">{data['resume']}</Link>
              <Link href="/projects" className="px-5 py-3">{data['projects']}</Link>
              <a href="mailto:me@fnbg.de" className='px-5 py-3 self-center'>me@fnbg.de</a>
              <Link href="https://www.linkedin.com/in/fabian-berger-nbg/" className="px-5 py-3" target="_blank">{data['linkedin']}</Link>
              <Link href="/imprint" className="px-5 py-3">{data['imprint']}</Link>
            </div>
          </div>
        </div>
      )}
    </nav>
  );
}
export default Navbar;
