package elone.hoo.mande.composables;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import elone.hoo.mande.plugins.request.RequestPlugin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class MandeTest {

  private Logger log = Logger.getLogger("elone.hoo.mande.composables");

  @Resource
  private Mande mande;

  @Test
  void useModel() {
    log.info("///////////////////////////////////////////////////////");
    log.info("MandeTest [" + log.getName() + ": " + "all mande" + "]");
    HttpRequest request = RequestPlugin.useRequest("http://localhost:8080/mande/" + "accept/model", "get");
    HttpResponse response = RequestPlugin.useExecute(request);
    System.out.println(response);
  }

}
