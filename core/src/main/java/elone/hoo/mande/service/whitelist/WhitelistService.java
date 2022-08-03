package elone.hoo.mande.service.whitelist;

import elone.hoo.mande.entity.whitelist.dto.InstallWhitelist;
import elone.hoo.mande.entity.whitelist.po.Whitelist;

public interface WhitelistService {
  Whitelist save(InstallWhitelist entity);
}
