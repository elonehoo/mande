package elone.hoo.mande.service.history;

import cn.hutool.http.HttpResponse;
import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.entity.model.po.Model;
import elone.hoo.mande.entity.whitelist.po.Whitelist;

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
  History save(History entity);

  /**
   * forward request, staging mode
   * @param whitelist whitelist entity
   * @param model model entity
   * @param entity install history entity
   * @return History entity
   */
  HttpResponse accept(Whitelist whitelist, Model model, InstallHistory entity);
}
