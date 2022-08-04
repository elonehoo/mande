package elone.hoo.mande.service.whitelist;

import elone.hoo.mande.entity.whitelist.dto.InstallWhitelist;
import elone.hoo.mande.entity.whitelist.po.Whitelist;

/**
 * Whitelist service implement
 * @author Elone Hoo <huchengyea@163.com>
 */
public interface WhitelistService {
  /**
   * enter the organization name to encrypt and add it into the whitelist data table, you can get the app_key
   * @param entity organization name
   * @return information registered into the database
   */
  Whitelist save(InstallWhitelist entity);

  /**
   * determine whether it can be called by app_key
   * @param appKey app_key
   * @return information in the database
   */
  Whitelist getByAppKey(String appKey);
}
