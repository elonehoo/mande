import { defineConfig } from 'vitepress'
const version = "0.0.2"
import {
  discord,
  font,
  github,
  description,
  name,
  releases,
  twitter,
} from './meta'

export default defineConfig({
  lang: 'en-US',
  title: name,
  description: description,
  head: [
    ['meta', { name: 'theme-color', content: '#ffffff' }],
    ['link', { rel: 'icon', href: '/logo.svg', type: 'image/svg+xml' }],
    ['meta', { property: 'og:title', content: name }],
    ['meta', { property: 'og:description', content: description }],
    ['meta', { name: 'twitter:title', content: name }],
    ['meta', { name: 'twitter:description', content: description }],
    ['meta', { name: 'twitter:card', content: 'summary_large_image' }],
    ['link', { href: font, rel: 'stylesheet' }],
    ['link', { rel: 'mask-icon', href: '/logo.svg', color: '#ffffff' }],
  ],
  lastUpdated: true,
  markdown: {
    theme: {
      light: 'vitesse-light',
      dark: 'vitesse-dark',
    },
  },
  themeConfig: {
    logo: '/logo.svg',
    editLink: {
      pattern: 'https://github.com/elonehoo/mande/tree/main/docs/:path',
      text: 'Suggest changes to this page',
    },
    localeLinks: {
      text: 'English',
      items: [
        { text: '简体中文', link: 'https://cn-mande.netlify.app' },
      ],
    },
    socialLinks: [
      { icon: 'twitter', link: twitter },
      { icon: 'discord', link: discord },
      { icon: 'github', link: github },
    ],
    footer: {
      message: 'Released under the MIT License.',
      copyright: 'Copyright © 2022-PRESENT Elone Hoo, zhy and Mande contributors',
    },
    nav: [
      { text: 'Guide', link: '/guide/' },
      { text: 'Docs', link: '/components/' },
      {
        text: `v${version}`,
        items: [
          {
            text: 'Release Notes ',
            link: releases,
          },
        ],
      },
    ],
    sidebar: {
      // TODO: bring sidebar of apis and config back
      '/guide/': [
        {
          text: 'Getting Started',
          items: [
            {
              text: 'Why mande',
              link: '/guide/why',
            },
            {
              text: 'Installation',
              link: '/guide/',
            },
            {
              text: 'Usage',
              link: '/guide/usage',
            },
          ],
        },
      ],
      '/components/': [
        {
          text: 'core',
          items: [
            {
              text: 'core',
              link: '/components/core',
            },
            {
              text: 'lib',
              link: '/components/lib',
            },
          ],
        },
      ],
    },
  },
})
