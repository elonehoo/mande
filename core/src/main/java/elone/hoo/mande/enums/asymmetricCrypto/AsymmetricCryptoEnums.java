package elone.hoo.mande.enums.asymmetricCrypto;

/**
 * enumeration of encryption modes
 * @author Elone Hoo <huchengyea@163.com>
 */
public enum AsymmetricCryptoEnums {

    RSA("RSA");

    private final String name;

    AsymmetricCryptoEnums(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
