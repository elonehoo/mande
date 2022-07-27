package elone.hoo.mande.enums.asymmetricCrypto;

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
