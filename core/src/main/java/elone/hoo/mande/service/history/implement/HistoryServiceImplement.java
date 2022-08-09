package elone.hoo.mande.service.history.implement;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import elone.hoo.mande.entity.history.dto.InstallHistory;
import elone.hoo.mande.entity.history.po.History;
import elone.hoo.mande.entity.model.po.Model;
import elone.hoo.mande.entity.whitelist.po.Whitelist;
import elone.hoo.mande.plugins.request.RequestPlugin;
import elone.hoo.mande.plugins.json.JsonPlugin;
import elone.hoo.mande.service.history.HistoryService;
import elone.hoo.mande.service.model.ModelService;
import elone.hoo.mande.store.history.HistoryStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * History service implement
 * @author Elone Hoo <huchengyea@163.com>
 */
@Service
public class HistoryServiceImplement implements HistoryService {

  @Resource
  private HistoryStore historyStore;

  @Resource
  private ModelService modelService;

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
   * @param promise promise status
   * @return History entity
   */
  @Override
  public HttpResponse accept(Whitelist whitelist, Model model, InstallHistory entity, String promise) {
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
    history.setPromise(promise);

    historyStore.save(history);
    return response;
  }

  /**
   * get history entity list by status
   *
   * @param flag false is to get the list of the history entity that is not processed
   * @return History entity list
   */
  @Override
  public List<History> getStateAndPromise(boolean flag,String promise) {
    List<History> histories = historyStore.findByStateAndPromise(flag,promise);
    return histories;
  }

  /**
   * The entity of the request may be repeated many times, and the location of the successful request is known
   *
   * @param entity History entity
   */
  @Override
  public void setTimeout(History entity) {
    Model model = modelService.getById(entity.getModelId());
    //get request method and url
    HttpRequest request = RequestPlugin.useRequest(model.getUrl(), model.getMethod());
    //get request header
    Map<String, String> headers = JsonPlugin.useJsonToMap(entity.getHeaders());
    RequestPlugin.useHeaders(request, headers);
    //get request body
    RequestPlugin.useBody(request, entity.getContent());
    // execute request
    HttpResponse response = RequestPlugin.useExecute(request);
    // determine whether the transmission is successful
    entity.setState(response.isOk());
    historyStore.save(entity);
  }
}
