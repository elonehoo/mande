package elone.hoo.mande.composables;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import elone.hoo.mande.enums.Promise;
import elone.hoo.mande.plugins.json.JsonPlugin;
import elone.hoo.mande.plugins.request.RequestPlugin;
import elone.hoo.mande.store.MandeStore;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class Mande {

  private Logger log = Logger.getLogger("elone.hoo.example.composables");

  private final MandeStore mandeStore;

  public HttpResponse useAccept(Promise promise, String modelId, Map<String,String> body, Map<String,String> headers) {
    log.info("useAccept" + log.getName() + "[ " + "start" + " ]");
    HttpRequest request = RequestPlugin.useRequest(mandeStore.getUrl() + "/accept/", "post");
    headers.put("app-key", mandeStore.getAppKey());
    headers.put("promise",promise.getValue());
    RequestPlugin.useHeaders(request, headers);
    body.put("modelId", modelId);
    RequestPlugin.useBody(request, JsonPlugin.useMapToJson(body));
    return RequestPlugin.useExecute(request);
  }

  public HttpResponse useAllModel(){
    log.info("useAllModel" + log.getName() + "[ " + "start" + " ]");
    HttpRequest request = RequestPlugin.useRequest(mandeStore.getUrl() + "/accept/model", "get");
    HashMap<String, String> headers = new HashMap<>();
    headers.put("app-key", mandeStore.getAppKey());
    RequestPlugin.useHeaders(request, headers);
    return RequestPlugin.useExecute(request);
  }

}
