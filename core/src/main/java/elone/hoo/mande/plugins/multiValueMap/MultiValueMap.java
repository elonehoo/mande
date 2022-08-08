package elone.hoo.mande.plugins.multiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiValueMap {

  public static Map<String, String> toMap(Map<String, List<String>> map) {
    Map<String, String> result = new HashMap<>();
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      result.put(entry.getKey(), entry.getValue().get(0));
    }
    return result;
  }
}
