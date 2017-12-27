package tech.simter.file.rest.spring.functional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;

/**
 * All application routes.
 *
 * @author RJ
 */
@Configuration
public class AppRoutes {
  @Bean
  RouterFunction<ServerResponse> indexRouterFunction(IndexPageHandler handler) {
    return nest(path("/"), handler.routes());
  }

  @Bean
  RouterFunction<ServerResponse> versionRouterFunction(VersionHandler handler) {
    return nest(path("/version"), handler.routes());
  }

  @Bean
  RouterFunction<ServerResponse> attachmentRouterFunction(AttachmentHandler handler) {
    return nest(path("/attachment"), handler.routes());
  }
}