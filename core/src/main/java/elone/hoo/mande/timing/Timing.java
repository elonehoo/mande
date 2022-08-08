package elone.hoo.mande.timing;

import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.service.history.HistoryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Component
public class Timing {

  private Logger log = Logger.getLogger("elone.hoo.mande.timing");

  @Resource
  private HistoryService historyService;

  @Scheduled(fixedRate = 18000)
  public void scheduledTask() {
    log.info("scheduledTask [" + log.getName() + ": " + LocalDateTime.now() + "]");
    List<History> lists = historyService.getStateAndPromise(false,"asynchronous");
    System.out.println(lists.size());
    lists.forEach(history -> {
      historyService.setTimeout(history);
    } );
  }

}
