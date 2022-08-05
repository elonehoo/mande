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

import java.util.HashMap;
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
    HttpRequest request = RequestPlugin.useRequest("http://localhost:8080/mande/yoho/get2", "get");
    Map<String,String> headers = new HashMap<>();
    headers.put("app-key","123");
    RequestPlugin.useHeaders(request, headers);
    HttpResponse response = RequestPlugin.useExecute(request);
    System.out.println(response);
    System.out.println(response.isOk());
  }

  @Test
  void regTest(){
    //中国身份证的正则
    String reg = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
    //中国手机电话号码的正则
    String reg2 = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
    //电子邮箱的正则
    String reg3 = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
    //中国社会统一信用代码的正则
    String reg4 = "^[0-9A-HJ-NPQRTUWXY]{2}[0-9A-HJ-NPQRTUWXY]{6}[0-9A-HJ-NPQRTUWXY]{10}$";

  }

}
