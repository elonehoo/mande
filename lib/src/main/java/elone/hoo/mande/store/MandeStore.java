package elone.hoo.mande.store;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("mande")
public class MandeStore {

  private String url = "http://localhost:8080/mande/";

  private Integer timeout = 5000;

  private String appKey = "";
}
