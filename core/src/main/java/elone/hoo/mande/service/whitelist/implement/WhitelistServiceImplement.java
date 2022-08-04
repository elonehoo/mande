package elone.hoo.mande.service.whitelist.implement;

import elone.hoo.mande.entity.whitelist.dto.InstallWhitelist;
import elone.hoo.mande.entity.whitelist.po.Whitelist;
import elone.hoo.mande.exception.UnauthorizedException;
import elone.hoo.mande.plugins.rsa.AsymmetricCryptoPlugin;
import elone.hoo.mande.service.whitelist.WhitelistService;
import elone.hoo.mande.store.whitelist.WhitelistStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * Whitelist service implement
 * @author Elone Hoo <huchengyea@163.com>
 */
@Service
public class WhitelistServiceImplement implements WhitelistService {

  private Logger log = Logger.getLogger("elone.hoo.mande.service.whitelist.implement");

  @Value("${appKey.publicKey}")
  private String publicKey;

  @Value("${appKey.privateKey}")
  private String privateKey;

  @Resource
  private WhitelistStore whitelistStore;

  /**
   * enter the organization name to encrypt and add it into the whitelist data table, you can get the app_key
   * @param entity organization name
   * @return information registered into the database
   */
  @Override
  public Whitelist save(InstallWhitelist entity) {
    //转换成为po
    Whitelist whitelist = entity.useWhitelist(publicKey);
    return whitelistStore.save(whitelist);
  }

  /**
   * determine whether it can be called by app_key
   * @param appKey app_key
   * @return information in the database
   */
  @Override
  public Whitelist getByAppKey(String appKey) {
    String decrypt;
    //解密
    try {
      decrypt = AsymmetricCryptoPlugin.useDecrypt(appKey,privateKey);
    } catch (Exception e) {
      throw new UnauthorizedException();
    }
    //通过解密之后的数据和密钥进行查找
    Whitelist entity = whitelistStore.findByAppKeyAndName(appKey,decrypt);
    return entity;
  }
}
