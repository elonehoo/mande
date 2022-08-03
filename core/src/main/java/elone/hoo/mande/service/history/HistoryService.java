package elone.hoo.mande.service.history;

import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;

/**
 * History service implement
 * @author Elone Hoo <huchengyea@163.com>
 */
public interface HistoryService {

  /**
   * Save history entity
   * @param entity History entity
   * @return History entity
   */
  History save(InstallHistory entity);
}
