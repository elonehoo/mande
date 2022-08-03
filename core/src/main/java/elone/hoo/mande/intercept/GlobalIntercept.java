package elone.hoo.mande.intercept;

import com.restful.Result;
import elone.hoo.mande.exception.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

/**
 * Global exception interceptor, which will intercept exceptions
 * @author Elone Hoo <huchengyea@163.com>
 * @since 2022/08/0/3 16:07
 */
@RestControllerAdvice
public class GlobalIntercept {

  private Logger log = Logger.getLogger("elone.hoo.mande.intercept");

  /**
   * 401 unauthorized
   * @param e Exception
   * @return unauthorized
   */
  @ExceptionHandler(value = UnauthorizedException.class)
  public Result UnauthorizedException(UnauthorizedException e){
    log.warning("UnauthorizedException ===> " + e.getMessage());
    return Result.unauthorized(e.getMessage());
  }

  @ExceptionHandler(value = IllegalArgumentException.class)
  public Result IllegalArgumentException(IllegalArgumentException e){
    log.warning("IllegalArgumentException ===> " + e.getMessage());
    return Result.unauthorized(e.getMessage());
  }

  @ExceptionHandler(value = Exception.class)
  public Result Exception(Exception e){
    log.warning("Exception ===> " + e.getMessage());
    return Result.unauthorized(e.getMessage());
  }
}
