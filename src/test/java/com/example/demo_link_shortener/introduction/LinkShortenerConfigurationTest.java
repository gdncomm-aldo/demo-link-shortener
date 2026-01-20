package com.example.demo_link_shortener.introduction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LinkShortenerConfigurationTest {

  /**
   * 1. Application Context
   * Verifies that the Spring ApplicationContext can be created successfully
   * using {@link LinkShortenerConfiguration}.
   * <p>
   * This test demonstrates the most basic Spring concept: starting the IoC
   * container (ApplicationContext) using a Java-based configuration class.
   * <p>
   * If the context is created without errors and is not null, it means:
   * - The configuration class is valid.
   * - Spring's dependency injection container starts correctly.
   * - The application is ready to manage beans.
   */
  @Test
  void linkShortenerApplicationContextTest(){
    ApplicationContext linkShortenerApplicationContext =
        new AnnotationConfigApplicationContext(LinkShortenerConfiguration.class);

    Assertions.assertNotNull(linkShortenerApplicationContext);
  }


}
