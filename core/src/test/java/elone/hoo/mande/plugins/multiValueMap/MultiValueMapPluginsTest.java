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
    map.put("key1", List.of("value1","value1-2","value1-3","value1-4"));
    map.put("key2", List.of("value2","value2-2","value2-3","value2-4"));
    map.put("key3", List.of("value3","value3-2","value3-3","value3-4"));
    System.out.println(map);
    MultiValueMap<String, String> result = MultiValueMapPlugins.toMap(map);
    System.out.println(result);
  }

}
