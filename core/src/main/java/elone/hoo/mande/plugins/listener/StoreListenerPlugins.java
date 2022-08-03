package elone.hoo.mande.plugins.listener;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class StoreListenerPlugins {

  @Value("${appKey.publicKey}")
  private String publicKey;

  @Value("${appKey.privateKey}")
  private String privateKey;

}
