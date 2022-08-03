package elone.hoo.mande.api;

import com.restful.Result;
import elone.hoo.mande.entity.whitelist.dto.InstallWhitelist;
import elone.hoo.mande.service.whitelist.WhitelistService;
import org.springframework.beans.factory.annotation.Value;
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

  @PostMapping("/")
  public Result register(@RequestBody InstallWhitelist entity) {
    return Result.success(whitelistService.save(entity));
  }

}
