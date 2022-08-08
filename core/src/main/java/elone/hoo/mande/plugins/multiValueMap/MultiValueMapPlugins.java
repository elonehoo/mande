package elone.hoo.mande.plugins.multiValueMap;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

public class MultiValueMapPlugins {

  public static MultiValueMap<String, String> toMap(Map<String, List<String>> map) {
    MultiValueMap<String, String> result = new LinkedMultiValueMap<>();
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      result.put(entry.getKey(), Collections.singletonList(String.valueOf(entry.getValue())));
    }
    return result;
  }
}
