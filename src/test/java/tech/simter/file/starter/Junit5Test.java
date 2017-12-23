package tech.simter.file.starter;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author RJ
 */
class Junit5Test {
  private static Logger logger = LoggerFactory.getLogger(Junit5Test.class);

  @Test
  void test() {
    logger.debug("test log config");
    assertEquals(2, 1 + 1);
  }
}