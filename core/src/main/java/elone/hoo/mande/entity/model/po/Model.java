package elone.hoo.mande.entity.model.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "model")
@Accessors(chain = true)
public class Model {

  @Id
  @GeneratedValue(generator = "snowFlakeIdPlugin")
  @GenericGenerator(name = "snowFlakeIdPlugin", strategy = "elone.hoo.mande.plugins.flake.SnowFlakeIdPlugin")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "url")
  private String url;

  @Column(name="method")
  private String method;

  @Column(name = "creation_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date creationTime;

  @Column(name = "modify_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date modifyTime;
}
