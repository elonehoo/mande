package elone.hoo.mande.api;

import com.restful.Result;
import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.service.history.HistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/accept")
public class Accept {

  @Resource
  private HistoryService historyService;

  @GetMapping("/hello")
  public Result hello() {
    return Result.success("hello");
  }

  @PostMapping("/install")
  public Result install(@RequestBody InstallHistory entity) {
    History history = historyService.save(entity);
    if (history == null) {
      return Result.failedDependency("save failed dependency");
    }
    return Result.success(true);
  }

}
