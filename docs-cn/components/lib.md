---
outline: deep
---

# lib

Mande 的 SpringBoot 官方插件

## 安装

### maven

```xml
<dependency>
  <groupId>io.github.xiaoxunyao</groupId>
  <artifactId>spring-boot-starter-mande</artifactId>
  <version>0.0.2</version>
</dependency>
```

### gradle

```groovy
implementation 'io.github.xiaoxunyao:spring-boot-starter-mande:0.0.2'
```

## 配置

在 yml 中快速简单地配置 mande

```yaml
# application.yml
mande:
  url: http://[ip]:[port]/mande
  appKey: [appkey]
```

## 简单使用

```java
import cn.hutool.http.HttpResponse;
import elone.hoo.mande.composables.Mande;
import elone.hoo.mande.enums.Promise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/hello")
public class Hello {

  private Logger log = Logger.getLogger("elone.hoo.example.api");

  @Resource
  private Mande mande;

  @GetMapping("/useAllModel")
  public void useAllModel(){
    log.info("start");
    HttpResponse response = mande.useAllModel();
    System.out.println(response);
    log.info("end");
  }

  @GetMapping("/useAccept")
  public void useAccept(){
    Map<String,String> map = new HashMap<>();
    HttpResponse response = mande.useAccept(Promise.SYNCHRONOUS, "426789596681076736", map, map);
    System.out.println(response);
  }

}
```

> 详情请浏览[示例](https://github.com/elonehoo/mande/tree/main/example)
