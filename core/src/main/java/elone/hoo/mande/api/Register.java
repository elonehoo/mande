package elone.hoo.mande.api;

import com.restful.Result;
import elone.hoo.mande.entity.model.dto.InstallModel;
import elone.hoo.mande.entity.whitelist.dto.InstallWhitelist;
import elone.hoo.mande.service.model.ModelService;
import elone.hoo.mande.service.whitelist.WhitelistService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/register")
public class Register {

  @Resource
  private WhitelistService whitelistService;

  @Resource
  private ModelService modelService;

  @PostMapping("/whitelist")
  public Result register(@RequestBody InstallWhitelist entity) {
    return Result.success(whitelistService.save(entity));
  }

  @PostMapping("/model")
  public Result model(@RequestBody InstallModel entity){
    return Result.success(modelService.save(entity));
  }

}
