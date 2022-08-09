package elone.hoo.mande.enums;

public enum Promise {
  SYNCHRONOUS("synchronous"),
  ASYNCHRONOUS("asynchronous");

  private final String value;

  Promise(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
