---
outline: deep
---

# Getting Started

## Overview

In the business, we may request the target server, but the target server is continuously attacked to the point of downtime, causing the business to stagnate, so we can only return an Error angrily, which will cause irreparable damage to the user, so Mande created us You can record the interface of the target server in Mande, and then send the request to Mande, and Mande will forward these requests. If the target server is down, Mande will continue to send requests until it succeeds. That way our business can continue.

You can learn more about the rationale behind the project in the [Why Mande](why) section.

## Environmental support

This is the environment in which I wrote Mande, and it does not mean that it must be run in this environment, but you can rest assured that there will be no errors in the environment below.

- JDK>= 17.0.2
- Node>= 16.15.1
- pnpm >= 7.9.0
- vite >= 3
