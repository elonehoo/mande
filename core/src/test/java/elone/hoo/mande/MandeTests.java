package elone.hoo.mande;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.service.history.HistoryService;
import org.springframework.boot.test.context.SpringBootTest;
import elone.hoo.mande.service.history.implement.HistoryServiceImplement;

@SpringBootTest
class MandeTests {

  @Resource
  private HistoryService historyService = new HistoryServiceImplement();

  @Test
  void contextLoads() {}

  @Test
  void saveHistory(){
  }

}
