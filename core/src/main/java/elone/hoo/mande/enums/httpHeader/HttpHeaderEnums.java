package elone.hoo.mande.enums.httpHeader;

public enum HttpHeaderEnums {

  // app-key
  APP_KEY("app-key");

  private final String name;

  HttpHeaderEnums(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
