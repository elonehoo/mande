package elone.hoo.mande.plugins.interceptor;

import elone.hoo.mande.plugins.author.AuthenticationPlugins;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Global interceptor, which can determine which requests need to be intercepted
 * @author Elone Hoo <huchengyea@163.com>
 */
@Configuration
public class GlobInterceptor implements WebMvcConfigurer {

  @Resource
  private AuthenticationPlugins authenticationPlugins;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authenticationPlugins)
      .addPathPatterns("/**")
      .excludePathPatterns("/register/whitelist", "/register/model");
  }
}
