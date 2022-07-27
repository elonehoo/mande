package elone.hoo.mande.entity.history.dto;

import elone.hoo.mande.entity.history.po.History;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InstallHistory {

  private String modelId;

  private String headers;

  private String content;

  public History useHistory() {
    return History.builder()
        .modelId(this.modelId)
        .headers(this.headers)
        .content(this.content)
        .createTime(new Date())
        .build();
  }

}
