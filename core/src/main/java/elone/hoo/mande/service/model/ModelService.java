package elone.hoo.mande.service.model;

import elone.hoo.mande.entity.model.dto.InstallModel;
import elone.hoo.mande.entity.model.po.Model;

/**
 * Model service
 * @author Elone Hoo <huchengyea@163.com>
 */
public interface ModelService {
  /**
   * Save model entity
   * @param entity install model entity
   * @return model entity
   */
  Model save(InstallModel entity);
}
