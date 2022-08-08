package elone.hoo.mande.plugins.multiValueMap;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

public class MultiValueMapPlugins {

  public static MultiValueMap<String, String> toMap(Map<String, List<String>> map) {
    //将Map<String, List<String>>转换成为Map<String,String>
    Map<String,String> center = new HashMap<>();
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      center.put(entry.getKey(), entry.getValue().toString());
    }
    //将Map<String,String>转换成为MultiValueMap<String,String>
    MultiValueMap<String, String> result = new LinkedMultiValueMap<>();
    for (Map.Entry<String, String> entry : center.entrySet()) {
      result.put(entry.getKey(), Collections.singletonList(entry.getValue()));
    }
    return result;
  }
}
