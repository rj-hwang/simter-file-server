package tech.simter.file.rest.spring.functional;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import tech.simter.file.data.Version;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * The version handler.
 *
 * @author RJ
 */
@Component
public class VersionHandler {
  private final Version version;

  public VersionHandler(Version version) {
    this.version = new Version(version);
  }

  private Mono<ServerResponse> get() {
    return ServerResponse.ok().contentType(APPLICATION_JSON_UTF8).syncBody(version);
  }

  RouterFunction<ServerResponse> routes() {
    return route(GET("/"), request -> this.get());
  }
}