package elone.hoo.mande.entity.history.dto;

import elone.hoo.mande.entity.history.po.History;
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
public class InstallHistory {

  private String modelId;

  private String headers;

  private String content;

  /**
   * convert the InstallHistory to History.
   * @return History
   */
  public History useHistory(String name) {
    return History.builder()
        .name(name)
        .modelId(this.modelId)
        .headers(this.headers)
        .content(this.content)
        .creationTime(new Date())
        .build();
  }

}
