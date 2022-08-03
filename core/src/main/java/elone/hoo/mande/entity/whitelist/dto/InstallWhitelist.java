package elone.hoo.mande.entity.whitelist.dto;

import elone.hoo.mande.entity.whitelist.po.Whitelist;
import elone.hoo.mande.plugins.listener.StoreListenerPlugins;
import elone.hoo.mande.plugins.rsa.AsymmetricCryptoPlugin;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class InstallWhitelist {

  private String name;

  public Whitelist useWhitelist(String publicKey) {
    try {
      return Whitelist.builder()
          .appKey(AsymmetricCryptoPlugin.useEncrypt(this.name,publicKey))
          .name(this.name)
          .creationTime(new Date())
          .build();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
