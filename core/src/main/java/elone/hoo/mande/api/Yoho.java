package elone.hoo.mande.api;

import com.restful.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yoho")
public class Yoho {
  @GetMapping("/get")
  public Result getYoho(){
    return Result.success("get yoho");
  }

  @PostMapping("/post")
  public Result postYoho(){
    return Result.success("post yoho");
  }

  @PutMapping("/put")
  public Result putYoho(){
    return Result.success("put yoho");
  }

  @DeleteMapping("/delete")
  public Result deleteYoho(){
    return Result.success("delete yoho");
  }
}
