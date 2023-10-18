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
            <div className='flex items-center'>
              <div className='px-2'>
                <Button onClick={() => handleLangButtonClick('en')}>EN</Button>
                <Button onClick={() => handleLangButtonClick('de')}>DE</Button>
              </div>
              <ThemeSwitcher />
              <button
                data-mobile-menu
                className="inline px-2 py-3 lg:hidden"
                onClick={toggleMobileMenu}
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  className="icon icon-tabler icon-tabler-menu-2"
                  width="24"
                  height="24"
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
