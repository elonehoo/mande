package elone.hoo.mande.entity.model.dto;

import elone.hoo.mande.entity.model.po.Model;
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
public class InstallModel {

  private String name;

  private String url;

  private String method;

  public Model useModel(){
    return Model.builder()
        .name(this.name)
        .url(this.url)
        .method(this.method)
        .creationTime(new Date())
        .build();
  }
}
