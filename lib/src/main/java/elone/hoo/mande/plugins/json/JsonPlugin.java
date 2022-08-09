package elone.hoo.mande.plugins.json;

import com.google.gson.Gson;

import java.util.Map;

public class JsonPlugin {

  public String useMapToJson(Map<String, String> map) {
    return new Gson().toJson(map);
  }
}
