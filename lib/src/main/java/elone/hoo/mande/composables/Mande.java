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

@RequiredArgsConstructor
public class Mande {

  private final MandeStore mandeStore;

  public HttpResponse useAccept(Promise promise, String modelId, Map<String,String> body, Map<String,String> headers) {
    HttpRequest request = RequestPlugin.useRequest(mandeStore.getUrl() + "accept/", "post");
    headers.put("app-key", mandeStore.getAppKey());
    headers.put("promise",promise.getValue());
    RequestPlugin.useHeaders(request, headers);
    body.put("modelId", modelId);
    RequestPlugin.useBody(request, JsonPlugin.useMapToJson(body));
    HttpResponse response = RequestPlugin.useExecute(request);
    return response;
  }

  public HttpResponse useAllModel(){
    HttpRequest request = RequestPlugin.useRequest(mandeStore.getUrl() + "accept/model", "get");
    HashMap<String, String> headers = new HashMap<>();
    headers.put("app-key", mandeStore.getAppKey());
    RequestPlugin.useHeaders(request, headers);
    HttpResponse response = RequestPlugin.useExecute(request);
    return response;
  }

}
