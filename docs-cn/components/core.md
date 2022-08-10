---
outline: deep
---

# Core

This is the core of this middleware. It has the capability of forwarding failure before forwarding and timing forwarding. We can define the method used by ourselves, or we can use the officially defined plug-in to control it later.

## API

| url                 | method | description                                              |
|:--------------------|:-------|:---------------------------------------------------------|
| /accept/            | POST   | send a request to determine if the target server is down |
| /register/whitelist | POST   | register a whitelisted user                              |
| /register/model     | POST   | register a model                                         |

### note

At present, it is still necessary to browse the source code and configure the forwarding logic specific to the business, but I think it is most likely the logic of browsing and forwarding, because the logic of forwarding is relatively open, and you can customize the body, header, url, and method, so I personally think it is not Needs to be modified too much. However, things can change as needed.

## Usage

```shell
git clone git@github.com:elonehoo/mande.git
```

Use idea or your favorite IDE to make personalized modifications, then package and deploy.
