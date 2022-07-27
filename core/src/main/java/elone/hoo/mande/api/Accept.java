package elone.hoo.mande.api;

import com.restful.Result;
import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.service.history.HistoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/accept")
public class Accept {

  @Resource
  private HistoryService historyService;

  @PostMapping("/install")
  public Result install(@RequestBody InstallHistory entity) {
    History history = historyService.save(entity);
    if (history == null) {
      return Result.failedDependency("save failed dependency");
    }
    return Result.success(true);
  }

}
