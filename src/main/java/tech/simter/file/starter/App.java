package tech.simter.file.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Application entry point.
 *
 * @author RJ
 */
@SpringBootApplication(scanBasePackages = "tech.simter")
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}