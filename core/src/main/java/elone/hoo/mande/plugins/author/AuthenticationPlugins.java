package elone.hoo.mande.plugins.author;

import elone.hoo.mande.entity.whitelist.po.Whitelist;
import elone.hoo.mande.exception.UnauthorizedException;
import elone.hoo.mande.service.whitelist.WhitelistService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Intercept before the controller to judge whether the app-key can be carried out.
 * @author Elone Hoo <huchengyea@163.com>
 */
@Order(1)
@Component
public class AuthenticationPlugins implements HandlerInterceptor {

  @Resource
  private WhitelistService whitelistService;

  private Logger log = Logger.getLogger("elone.hoo.mande.plugins.author");

  /**
   * Intercept before the controller to judge whether the app-key can be carried out.
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @param handler Object
   * @return boolean
   * @throws Exception There may be many problems in the middle
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String appKey = request.getHeader("app-key");
    log.info("app-key [" + log.getName() + ": " + appKey + "]");
    Whitelist whitelist = whitelistService.getByAppKey(appKey);
    if (whitelist == null) {
      throw new UnauthorizedException();
    }
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }
}
