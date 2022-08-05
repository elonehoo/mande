package elone.hoo.mande.error;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.logging.Logger;

@Configuration
public class Mistake {

  private Logger log = Logger.getLogger("elone.hoo.mande.error");

  @Bean("error")
  public View error() {
    log.warning("error");
    return (model, request, response) -> {
      response.setStatus(500);
      response.setContentType("application/json");
      response.getWriter().write("{\"code\":500,\"message\":\"error\"}");
    };
  }

}
