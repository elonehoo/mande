package elone.hoo.mande.plugins.request;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;

import java.util.Map;

public class RequestPlugin {

  public static HttpRequest useRequest(String url,String method) {
    return switch (method) {
      case "post", "POST" -> HttpRequest.of(url).method(Method.POST);
      case "put", "PUT" -> HttpRequest.of(url).method(Method.PUT);
      case "delete", "DELETE" -> HttpRequest.of(url).method(Method.DELETE);
      case "head", "HEAD" -> HttpRequest.of(url).method(Method.HEAD);
      case "options", "OPTIONS" -> HttpRequest.of(url).method(Method.OPTIONS);
      case "trace", "TRACE" -> HttpRequest.of(url).method(Method.TRACE);
      case "connect", "CONNECT" -> HttpRequest.of(url).method(Method.CONNECT);
      default -> HttpRequest.of(url).method(Method.GET);
    };
  }

  public static HttpRequest useHeaders(HttpRequest request,Map<String,String> headers){
    return request.headerMap(headers,true);
  }

  public static HttpRequest useBody(HttpRequest request,String json){
    return request.body(json);
  }

  public static HttpResponse useExecute(HttpRequest request){
    return request.execute();
  }
}
