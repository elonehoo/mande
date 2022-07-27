package elone.hoo.mande.plugins.author;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

@Order(1)
@Component
public class AuthenticationPlugins implements Filter {

  private Logger log = Logger.getLogger("elone.hoo.mande.plugins.author");

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

    filterChain.doFilter(servletRequest, servletResponse);
  }
}
