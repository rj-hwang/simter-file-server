package tech.simter.file.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.simter.file.data.Attachment;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {
  @Override
  public Mono<Attachment> get(Long id) {
    return Mono.empty();
  }

  @Override
  public Flux<Attachment> list() {
    // demo
    List<Attachment> list = new ArrayList<>();
    for (int i = 1; i <= 3; i++) list.add(new Attachment((long) i, "Simter" + i));
    return Flux.fromIterable(list);
  }

  @Override
  public Mono<Void> save(Mono<Attachment> attachment) {
    return Mono.empty();
  }
}