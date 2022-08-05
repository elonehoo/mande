package elone.hoo.mande.error;

import com.restful.Result;
import elone.hoo.mande.exception.NotFountException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.logging.Logger;

@RestController
public class Mistake {

  private Logger log = Logger.getLogger("elone.hoo.mande.error");

  @GetMapping("/error")
  public Result error() {
    throw new NotFountException();
  }

}
