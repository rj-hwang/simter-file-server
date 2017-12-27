package tech.simter.file.rest.spring.annotated;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * The hello annotated-controller. Just for comparison to functional-endpoint.
 *
 * @author RJ
 */
// see https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-ann-arguments
@RestController
@RequestMapping("/hello")
public class HelloController {
  // text/html;charset=UTF-8
  @GetMapping()
  public String hello() {
    return "Hello By Annotated Controller.";
  }

  // application/json;charset=UTF-8;q=0.8
  @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
  public HelloDto one(@PathVariable Long id) {
    return new HelloDto(id, "Simter");
  }

  // application/json;q=0.8;charset=UTF-8
  @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
  public List<HelloDto> list(@RequestParam(required = false, name = "search") String search) {
    return Arrays.asList(new HelloDto(1L, search), new HelloDto(2L, "Simter"));
  }

  public static class HelloDto {
    public Long id;
    public String name;

    public HelloDto(Long id, String name) {
      this.id = id;
      this.name = name;
    }
  }
}