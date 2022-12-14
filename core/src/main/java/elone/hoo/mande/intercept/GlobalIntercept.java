package elone.hoo.mande.intercept;

import com.restful.Result;
import elone.hoo.mande.exception.NotFountException;
import elone.hoo.mande.exception.UnauthorizedException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.ServerException;
import java.util.logging.Logger;

/**
 * Global exception interceptor, which will intercept exceptions
 * @author Elone Hoo <huchengyea@163.com>
 * @since 2022/08/0/3 16:07
 */
@RestControllerAdvice
@ResponseBody
public class GlobalIntercept {

  private Logger log = Logger.getLogger("elone.hoo.mande.intercept");

  /**
   * 401 unauthorized
   * @param e Exception
   * @return unauthorized
   */
  @ExceptionHandler(value = UnauthorizedException.class)
  public Result UnauthorizedException(UnauthorizedException e){
    log.warning("UnauthorizedException [" + log.getName() + ": " + e.getMessage() + "]");
    return Result.unauthorized(e.getMessage());
  }

  @ExceptionHandler(value = IllegalArgumentException.class)
  public Result IllegalArgumentException(IllegalArgumentException e){
    log.warning("IllegalArgumentException [" + log.getName() + ": " + e.getMessage() + "]");
    return Result.unauthorized(e.getMessage());
  }

  @ExceptionHandler(value = Exception.class)
  public Result Exception(Exception e){
    log.warning("Exception [" + log.getName() + ": " + e.getMessage() + "]");
    return Result.unauthorized(e.getMessage());
  }

  @ExceptionHandler(value = NotFountException.class)
  public Result NotFoundException(NotFountException e){
    log.warning("NotFoundException [" + log.getName() + ": " + e.getMessage() + "]");
    return Result.unauthorized(e.getMessage());
  }

  @ExceptionHandler(value = ServerException.class)
  public Result ServerException(ServerException e){
    log.warning("ServerException [" + log.getName() + ": " + e.getMessage() + "]");
    return Result.unauthorized(e.getMessage());
  }
}
