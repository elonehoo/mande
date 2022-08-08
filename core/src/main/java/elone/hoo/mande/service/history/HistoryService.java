package elone.hoo.mande.service.history;

import cn.hutool.http.HttpResponse;
import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.entity.model.po.Model;
import elone.hoo.mande.entity.whitelist.po.Whitelist;

import java.util.List;

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
   * @param promise promise status
   * @return History entity
   */
  HttpResponse accept(Whitelist whitelist, Model model, InstallHistory entity, String promise);

  /**
   * get history entity list by status
   * @param flag false is to get the list of the history entity that is not processed
   * @return History entity list
   */
  List<History> getStateAndPromise(boolean flag,String promise);

  /**
   * The history of the request may be repeated many times, and the location of the successful request is known
   * @param entity history entity
   */
  void setTimeout(History entity);
}
