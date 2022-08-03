package elone.hoo.mande.enums.httpHeader;

/**
 * enumeration of http headers
 * @author Elone Hoo <huchengyea@163.com>
 */
public enum HttpHeaderEnums {

  APP_KEY("app-key"),
  APP_PAIR("app-pair")
  ;

  private final String name;

  HttpHeaderEnums(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
