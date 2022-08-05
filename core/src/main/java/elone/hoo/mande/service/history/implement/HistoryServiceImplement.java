package elone.hoo.mande.service.history.implement;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.entity.model.po.Model;
import elone.hoo.mande.entity.whitelist.po.Whitelist;
import elone.hoo.mande.plugins.RequestPlugin.RequestPlugin;
import elone.hoo.mande.plugins.json.JsonPlugin;
import elone.hoo.mande.service.history.HistoryService;
import elone.hoo.mande.store.history.HistoryStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * History service implement
 * @author Elone Hoo <huchengyea@163.com>
 */
@Service
public class HistoryServiceImplement implements HistoryService {

  @Resource
  private HistoryStore historyStore;

  /**
   * Save history entity
   * @param entity History entity
   * @return History entity
   */
  @Override
  public History save(History entity) {
    History history = historyStore.save(entity);
    return history;
  }

  /**
   * forward request, staging mode
   *
   * @param whitelist whitelist entity
   * @param model     model entity
   * @param entity    install history entity
   * @return History entity
   */
  @Override
  public HttpResponse accept(Whitelist whitelist, Model model, InstallHistory entity) {
    String historyName = whitelist.getName() + "[ request ]" + model.getName();
    History history = entity.useHistory(historyName);
    //get request method and url
    String method = model.getMethod();
    String url = model.getUrl();
    //set method and url
    HttpRequest request = RequestPlugin.useRequest(url, method);
    //get request header
    Map<String, String> headers = JsonPlugin.useJsonToMap(entity.getHeaders());
    RequestPlugin.useHeaders(request, headers);
    //get request body
    RequestPlugin.useBody(request, entity.getContent());
    // execute request
    HttpResponse response = RequestPlugin.useExecute(request);
    // determine whether the transmission is successful
    history.setState(response.isOk());

    historyStore.save(history);
    return response;
  }
}
