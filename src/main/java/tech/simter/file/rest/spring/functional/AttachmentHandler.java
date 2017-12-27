package tech.simter.file.rest.spring.functional;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.simter.file.data.Attachment;
import tech.simter.file.service.AttachmentService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * The attachment handler.
 *
 * @author RJ
 */
@Component
public class AttachmentHandler {
  private final AttachmentService service;

  public AttachmentHandler(AttachmentService service) {
    this.service = service;
  }

  private Mono<ServerResponse> get(ServerRequest request) {
    Long id = new Long(request.pathVariable("id"));
    Mono<ServerResponse> notFound = ServerResponse.notFound().build();
    Mono<Attachment> personMono = this.service.get(id);
    return personMono
      .flatMap(person -> ServerResponse.ok().contentType(APPLICATION_JSON_UTF8).body(fromObject(person)))
      .switchIfEmpty(notFound);
  }

  private Mono<ServerResponse> list() {
    Flux<Attachment> people = service.list();
    return ServerResponse.ok().contentType(APPLICATION_JSON_UTF8).body(people, Attachment.class);
  }

  private Mono<ServerResponse> create(ServerRequest request) {
    Mono<Attachment> attachment = request.bodyToMono(Attachment.class);
    return ServerResponse.ok().build(service.save(attachment));
  }

  RouterFunction<ServerResponse> routes() {
    return route(GET("/{id}"), this::get)
      .andRoute(GET("/"), request -> this.list())
      .andRoute(POST("/"), this::create);
  }
}