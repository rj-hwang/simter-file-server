package tech.simter.file.starter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.resource.VersionResourceResolver;

import java.util.concurrent.TimeUnit;

/**
 * WebFlux configuration.
 *
 * @author RJ
 */
@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**")
      .addResourceLocations("classpath:/META-INF/resources/static/")
      .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS))
      .resourceChain(false)
      .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // Enabling CORS for the whole application
    // By default all origins and GET, HEAD, and POST methods are allowed
    registry.addMapping("/**");
  }
}