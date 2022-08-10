---
outline: deep
---

# Core

中间件的核心包。
具有转发失败前转发能力和定时转发能力。
我们可以自己定义使用的方法，也可以在以后使用官方定义的插件来控制。

## API

| url                 | method | description       |
|:--------------------|:-------|:------------------|
| /accept/            | POST   | 发送请求以确定目标服务器是否已关闭 |
| /register/whitelist | POST   | 注册白名单用户           |
| /register/model     | POST   | 注册一个模型            |

### 提示

目前还是需要浏览源码，
配置业务具体的转发逻辑，
但我觉得大概率是浏览转发的逻辑，
因为转发的逻辑比较开放，
可以自定义 body、header、url、method，所以个人认为不需要过多修改。 但是可以根据需要改变。

## 使用

```shell
git clone git@github.com:elonehoo/mande.git
```

使用idea或者你喜欢的IDE进行个性化修改，然后打包部署。
