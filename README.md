<div align="center">

<img src="./public/logo.svg">

</div>

<div align="center">

<h1>Mande</h1>

</div>

<div align="center">

>A java middleware that only focuses on forwarding

</div>

## Features

- ⚡️ [SpringBoot](https://github.com/spring-projects/spring-boot), [JPA](https://github.com/spring-projects/spring-data-jpa), [Restful](https://github.com/elonehoo/restful-return) - born with fastness.
- 🗂 [SpringNative](https://github.com/spring-projects-experimental/spring-native) - provides beta support for compiling Spring applications to native executables using GraalVM native-image compiler.
- 🔥 [lombok](https://github.com/projectlombok/lombok) - Very spicy additions to the Java programming language.

## Usage

```shell
git clone git@github.com:elonehoo/mande.git
```

Use idea or your favorite IDE to make personalized modifications, then package and deploy.

## File

```markdown
- mande
 - [lib](Jar packages bound to other businesses can be downloaded through maven)
 - [core](middleware code)
 - [database](sql file)
 - [docs](Documentation written with VitePress)
 - [web](possible front end)
```

## API

### core-api

| url                 | method | description                                              |
|:--------------------|:-------|:---------------------------------------------------------|
| /accept/            | POST   | send a request to determine if the target server is down |
| /register/whitelist | POST   | register a whitelisted user                              |
| /register/model     | POST   | register a model                                         |
