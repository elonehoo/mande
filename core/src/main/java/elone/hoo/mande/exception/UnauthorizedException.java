package elone.hoo.mande.exception;

import java.io.Serial;
import java.util.logging.Logger;

/**
 * Indicates that the request requires user authentication information.
 * The client MAY repeat the request with a suitable Authorization header field.
 * @author Elone Hoo <huchengyea@163.com>
 */
public class UnauthorizedException extends RuntimeException{
  @Serial
  private static final long serialVersionUID = 5776681206288518465L;

  private Logger log = Logger.getLogger("elone.hoo.mande.exception");

  public UnauthorizedException() {
    super("the requires user authentication information.");
  }

  public UnauthorizedException(Throwable cause) {
    super("the requires user authentication information.", cause);
  }
}
