package elone.hoo.mande;

import javax.annotation.Resource;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;
import elone.hoo.mande.enums.httpHeader.HttpHeaderEnums;
import elone.hoo.mande.plugins.RequestPlugin.RequestPlugin;
import elone.hoo.mande.plugins.json.JsonPlugin;
import elone.hoo.mande.plugins.rsa.AsymmetricCryptoPlugin;
import org.junit.jupiter.api.Test;
import elone.hoo.mande.service.history.HistoryService;
import org.springframework.boot.test.context.SpringBootTest;
import elone.hoo.mande.service.history.implement.HistoryServiceImplement;

import java.util.Map;

@SpringBootTest
class MandeTests {

  @Resource
  private HistoryService historyService = new HistoryServiceImplement();

  @Test
  void contextLoads() {}

  @Test
  void saveHistory(){
//    historyService.save(new InstallHistory().setModelId("1").setContent("1").setHeaders("1"));
  }

  @Test
  void httpHeader(){
    System.out.println(HttpHeaderEnums.APP_KEY.getName());
  }

  @Test
  void asymmetricCryptoTest() throws Exception {
    Map<Integer, String> keyPair = AsymmetricCryptoPlugin.useKeyPair();
    System.out.println(keyPair.get(0));
    System.out.println("///////////////////////////////////////////////////");

    System.out.println(keyPair.get(1));
    System.out.println("///////////////////////////////////////////////////");

    String encrypt = AsymmetricCryptoPlugin.useEncrypt("EloneHoo", keyPair.get(0));
    System.out.println(encrypt);
    System.out.println("///////////////////////////////////////////////////");

    System.out.println(AsymmetricCryptoPlugin.useDecrypt(encrypt, keyPair.get(1)));

  }

  @Test
  void jsonPath(){
    String json = "{\"name\":\"EloneHoo\",\"age\":\"18\",\"address\":\"hz\"}";
    System.out.println(JsonPlugin.useJsonToMap(json));
  }

  @Test
  void HttpTest(){
    HttpRequest request = RequestPlugin.useRequest("http://localhost:8080/mande/yoho/get", "get");
    HttpResponse response = RequestPlugin.useExecute(request);
    System.out.println(response);
  }

}
