package elone.hoo.mande.plugins.rsa;

import elone.hoo.mande.enums.asymmetricCrypto.AsymmetricCryptoEnums;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class AsymmetricCryptoPlugin {

  /**
   * Randomly generate key pair
   */
  public static Map<Integer, String> useKeyPair() throws Exception {

    Map<Integer,String> keyMap=new HashMap<>();
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(AsymmetricCryptoEnums.RSA.getName());

    keyPairGen.initialize(1024,new SecureRandom());
    KeyPair keyPair = keyPairGen.generateKeyPair();
    PrivateKey privateKey = keyPair.getPrivate();
    PublicKey publicKey = keyPair.getPublic();

    String publicKeyString=new String(Base64.encodeBase64(publicKey.getEncoded()));
    String privateKeyString=new String(Base64.encodeBase64(privateKey.getEncoded()));

    keyMap.put(0,publicKeyString);
    keyMap.put(1,privateKeyString);

    return keyMap;
  }

  /**
   * Encrypt data with public key
   */
  public static String useEncrypt(String str,String publicKey) throws Exception {
    byte[] decoded = Base64.decodeBase64(publicKey);

    RSAPublicKey pubKey= (RSAPublicKey) KeyFactory.getInstance(AsymmetricCryptoEnums.RSA.getName()).generatePublic(new X509EncodedKeySpec(decoded));
    Cipher cipher = Cipher.getInstance(AsymmetricCryptoEnums.RSA.getName());

    cipher.init(Cipher.ENCRYPT_MODE,pubKey);

    return Base64.encodeBase64String(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
  }

  /**
   * Decrypt data with private key
   */
  public static String useDecrypt(String str,String privateKey) throws Exception {
    byte[] inputByte = Base64.decodeBase64(str.getBytes(StandardCharsets.UTF_8));
    byte[] decoded = Base64.decodeBase64(privateKey);

    PrivateKey priKey = KeyFactory.getInstance(AsymmetricCryptoEnums.RSA.getName()).generatePrivate(new PKCS8EncodedKeySpec(decoded));

    Cipher cipher = Cipher.getInstance(AsymmetricCryptoEnums.RSA.getName());
    cipher.init(Cipher.DECRYPT_MODE,priKey);

    return new String(cipher.doFinal(inputByte));

  }
}
