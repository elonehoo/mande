package elone.hoo.mande.modules;

import elone.hoo.mande.composables.Mande;
import elone.hoo.mande.store.MandeStore;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MandeStore.class)
public class MandeModules {

  private final MandeStore mandeStore;

  @Bean
  @ConditionalOnMissingBean(Mande.class)
  public Mande redisComponent(MandeStore mandeStore) {
    return new Mande(mandeStore);
  }

}
