package elone.hoo.mande.api;

import com.axios.Axios;
import com.restful.Result;
import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.entity.model.po.Model;
import elone.hoo.mande.entity.whitelist.po.Whitelist;
import elone.hoo.mande.service.history.HistoryService;
import elone.hoo.mande.service.model.ModelService;
import elone.hoo.mande.service.whitelist.WhitelistService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * accept request
 * @author Elone Hoo <huchengyea@163.com>
 */
@RestController
@RequestMapping("/accept")
public class Accept {

  @Resource
  private WhitelistService whitelistService;

  @Resource
  private ModelService modelService;

  @Resource
  private HistoryService historyService;

  @PostMapping("/")
  public Result accept(@RequestHeader(name = "app-key") String appKey,@RequestBody InstallHistory entity){
    Whitelist whitelist = whitelistService.getByAppKey(appKey);
    Model model= modelService.getById(entity.getModelId());
    History history = historyService.accept(whitelist,model,entity);
    return Result.success(history);
  }

}
