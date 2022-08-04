package elone.hoo.mande.plugins.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Json Plugin
 * @author Elone Hoo <huchengyea@163.com>
 */
public class JsonPlugin {

  /**
   * Json to map
   * @param json Json string
   * @return Map
   */
  public static Map<String,String> useJsonToMap(String json){
    Gson gson = new Gson();
    //get type
    Type mapType = new TypeToken<Map<String, String>>(){}.getType();
    //parse json
    return gson.fromJson(json, mapType);
  }
}
