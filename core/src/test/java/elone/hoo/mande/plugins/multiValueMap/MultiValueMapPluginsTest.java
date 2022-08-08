package elone.hoo.mande.plugins.multiValueMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MultiValueMapPluginsTest {
  @Test
  void toMapTest() {
    Map<String, List<String>> map = new HashMap<>();
    map.put("Keep-Alive", List.of("timeout=60"));
    map.put("null", List.of("HTTP/1.1 404"));
    map.put("Connection", List.of("keep-alive"));
    map.put("Content-Length", List.of("8"));
    map.put("Date", List.of("Mon, 08 Aug 2022 05:55:40 GMT"));
    map.put("Content-Type", List.of("text/html;charset=UTF-8"));
    System.out.println(map);
    MultiValueMap<String, String> result = MultiValueMapPlugins.toMap(map);
    System.out.println(result);
  }

}
