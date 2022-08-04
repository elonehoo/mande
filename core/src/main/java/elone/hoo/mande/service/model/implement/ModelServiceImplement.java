package elone.hoo.mande.service.model.implement;

import elone.hoo.mande.entity.model.dto.InstallModel;
import elone.hoo.mande.entity.model.po.Model;
import elone.hoo.mande.service.model.ModelService;
import elone.hoo.mande.store.model.ModelStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Model service implement
 * @author Elone Hoo <huchengyea@163.com>
 */
@Service
public class ModelServiceImplement implements ModelService {

  @Resource
  private ModelStore modelStore;

  /**
   * Save model entity
   *
   * @param entity install model entity
   * @return model entity
   */
  @Override
  public Model save(InstallModel entity) {
    return modelStore.save(entity.useModel());
  }
}
