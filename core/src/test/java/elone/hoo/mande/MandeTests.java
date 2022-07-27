package elone.hoo.mande;

import javax.annotation.Resource;

import elone.hoo.mande.entity.history.dto.InstallHistory;
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
    historyService.save(new InstallHistory().setModelId("1").setContent("1").setHeaders("1"));
  }

}
