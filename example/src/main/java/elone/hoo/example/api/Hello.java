package elone.hoo.example.api;

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
