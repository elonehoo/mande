package elone.hoo.mande.service.model;

import elone.hoo.mande.entity.model.dto.InstallModel;
import elone.hoo.mande.entity.model.po.Model;

import java.util.List;

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

  /**
   * Get model entity by id
   * @param modelId model id
   * @return model entity
   */
  Model getById(String modelId);

  /**
   * Get all model entity
   * @return model entity list
   */
  List<Model> getAll();
}
