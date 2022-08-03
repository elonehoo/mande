package elone.hoo.mande.service.whitelist.implement;

import elone.hoo.mande.entity.whitelist.dto.InstallWhitelist;
import elone.hoo.mande.entity.whitelist.po.Whitelist;
import elone.hoo.mande.service.whitelist.WhitelistService;
import elone.hoo.mande.store.whitelist.WhitelistStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WhitelistServiceImplement implements WhitelistService {


  @Value("${appKey.publicKey}")
  private String publicKey;

  @Value("${appKey.privateKey}")
  private String privateKey;

  @Resource
  private WhitelistStore whitelistStore;

  @Override
  public Whitelist save(InstallWhitelist entity) {
    //转换成为po
    Whitelist whitelist = entity.useWhitelist(publicKey);
    return whitelistStore.save(whitelist);
  }
}
