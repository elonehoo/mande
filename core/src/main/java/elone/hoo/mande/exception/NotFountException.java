package elone.hoo.mande.exception;

import java.io.Serial;
import java.util.logging.Logger;

public class NotFountException extends RuntimeException{
  @Serial
  private static final long serialVersionUID = 5776681206288518465L;

  private Logger log = Logger.getLogger("elone.hoo.mande.exception");

  public NotFountException() {
    super("The server can not find the requested resource.");
  }

  public NotFountException(Throwable cause) {
    super("The server can not find the requested resource.", cause);
  }
}
