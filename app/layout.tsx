import './globals.css'
import type { Metadata } from 'next'
import { Inter } from 'next/font/google'
import { Providers } from './providers'
import Navbar from './components/Navbar/Navbar'
import Footer from './components/Footer/Footer';
import Wp from './components/Wp/Wp'

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: 'Fabian Berger',
  description: 'Fabian Berger - Web Designer',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      <head />
      <body className={inter.className}><Providers>
        <Navbar />
        {children}
        <Footer />
        {/* <Wp /> */}
      </Providers>
      </body>
    </html>
  )
}
