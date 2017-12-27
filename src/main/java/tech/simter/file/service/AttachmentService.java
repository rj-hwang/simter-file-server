package tech.simter.file.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.simter.file.data.Attachment;

public interface AttachmentService {
  Mono<Attachment> get(Long id);

  Flux<Attachment> list();

  Mono<Void> save(Mono<Attachment> attachment);
}