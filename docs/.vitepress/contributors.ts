export interface SocialEntry {
  icon: string
  link: string
}

export interface CoreTeam {
  avatar: string
  name: string
  // required to download avatars from GitHub
  github: string
  twitter: string
  sponsor?: string
  title?: string
  org?: string
  desc?: string
  links?: SocialEntry[]
}



const createLinks = (tm: CoreTeam): CoreTeam => {
  tm.links = [
    { icon: 'github', link: `https://github.com/${tm.github}` },
    { icon: 'twitter', link: `https://twitter.com/${tm.twitter}` },
  ]
  return tm
}

const plainTeamMembers: CoreTeam[] = [
  {
    avatar: 'https://github.com/elonehoo.png',
    name: 'Elone Hoo',
    github: 'elonehoo',
    twitter: 'huchengye',
    title: 'A fullstack and PWA developer',
    desc: 'Vite\'s fanatical follower',
  },
  {
    avatar: 'https://github.com/wuaqing.png',
    name: 'wuaqing',
    github: 'wuaqing',
    twitter: 'wushiqingya',
    title: 'A collaborative being',
    desc: 'Creating tools for collaboration',
  },
  {
    avatar: 'https://github.com/2434017367.png',
    name: 'zhy',
    github: '2434017367',
    twitter: 'unknown',
    title: 'A tech lead, fullstack developer',
    desc: 'Author of minio-serve-java',
  },
  {
    avatar: 'https://github.com/wkx160312746.png',
    name: 'Fenta',
    github: 'wkx160312746',
    twitter: 'unknown',
    title: 'A fullstack developer',
    desc: 'Comes up with good ideas',
  },
  {
    avatar: 'https://github.com/011011100.png',
    name: 'Li-Zhuohan',
    github: '011011100',
    twitter: 'unknown',
    title: 'An open source developer',
    desc: 'Core team member of INet',
  },
]

const teamMembers = plainTeamMembers.map(tm => createLinks(tm))

export { teamMembers }
