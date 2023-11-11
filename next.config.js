/** @type {import('next').NextConfig} */
const nextConfig = {
    output: 'export',
    trailingSlash: true,
    compiler: {
        // Enables the styled-components SWC transform to fix warning --> not working!
        styledComponents: true
    }
}

module.exports = nextConfig
