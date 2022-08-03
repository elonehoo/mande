package elone.hoo.mande.api;

import com.restful.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/accept")
public class Accept {

  @GetMapping("/hello")
  public Result hello() {
    return Result.success("hello");
  }

}
