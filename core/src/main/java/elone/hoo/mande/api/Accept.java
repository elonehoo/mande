package elone.hoo.mande.api;

import cn.hutool.http.HttpResponse;
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
import java.util.logging.Logger;

/**
 * accept request
 * @author Elone Hoo <huchengyea@163.com>
 */
@RestController
@RequestMapping("/accept")
public class Accept {

  private Logger log = Logger.getLogger("elone.hoo.mande.api");

  @Resource
  private WhitelistService whitelistService;

  @Resource
  private ModelService modelService;

  @Resource
  private HistoryService historyService;

  /**
   * send a request to determine if the target server is down
   * @param appKey the app key
   * @param entity the request entity
   * @return the result return value supported by standard V8 browsers
   */
  @PostMapping("/")
  public Result accept(@RequestHeader(name = "app-key") String appKey,@RequestBody InstallHistory entity){
    Whitelist whitelist = whitelistService.getByAppKey(appKey);
    Model model= modelService.getById(entity.getModelId());
    HttpResponse accept = historyService.accept(whitelist, model, entity);
    return Result.success(accept.body());
  }

}
