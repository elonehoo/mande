package elone.hoo.mande.timing;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Component
public class Timing {

  private Logger log = Logger.getLogger("elone.hoo.mande.timing");

//  @Scheduled(fixedRate = 3000)
  public void scheduledTask() {
    log.info("scheduledTask [" + log.getName() + ": " + LocalDateTime.now() + "]");
  }

}
