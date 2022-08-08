package elone.hoo.mande.entity.history.po;

import lombok.*;
import java.util.Date;
import javax.persistence.*;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * associate the History database and connect through JPA.
 * @author Elone Hoo <huchengyea@164.com>
 */
@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "history")
@Accessors(chain = true)
public class History {

  @Id
  @GeneratedValue(generator = "snowFlakeIdPlugin")
  @GenericGenerator(name = "snowFlakeIdPlugin", strategy = "elone.hoo.mande.plugins.flake.SnowFlakeIdPlugin")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "model_id")
  private String modelId;

  @Column(name = "headers")
  private String headers;

  @Column(name = "content")
  private String content;

  @Column(name = "state")
  private Boolean state;

  @Column(name = "promise")
  private String promise;

  @Column(name = "creation_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date creationTime;

  @Column(name = "modify_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date modifyTime;

}
