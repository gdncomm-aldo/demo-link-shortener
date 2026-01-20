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

  /**
   * 2. Spring bean
   * Verifies that Spring beans are singleton by default.
   * <p>
   * This test retrieves the same bean type twice from the
   * ApplicationContext and asserts that both references
   * point to the exact same object instance.
   * <p>
   * This demonstrates Spring's default bean scope: singleton,
   * meaning one shared instance per IoC container.
   */
  @Test
  void linkShortenerBeanTest(){
    ApplicationContext linkShortenerApplicationContext =
        new AnnotationConfigApplicationContext(LinkShortenerConfiguration.class);

    User user1 = linkShortenerApplicationContext.getBean(User.class);
    User user2 = linkShortenerApplicationContext.getBean(User.class);

    Assertions.assertEquals(user1, user2);
  }

  /**
   * 3. Duplicate Bean
   * Verifies that multiple beans of the same type can coexist in the Spring ApplicationContext
   * as long as they have unique bean names.
   * <p>
   * This test retrieves two User beans by their bean names
   * and confirms that they are different instances, even though they share the same type.
   */
  @Test
  void linkShortenerDuplicateBeanTest(){
    ApplicationContext linkShortenerApplicationContext =
        new AnnotationConfigApplicationContext(LinkShortenerConfiguration.class);

    User user1 = linkShortenerApplicationContext.getBean("firstUser", User.class);
    User user2 = linkShortenerApplicationContext.getBean("secondUser", User.class);

    Assertions.assertNotEquals(user1, user2);
  }

  /**
   * 4. Primary bean
   * Verifies that the @Primary annotation marks a bean as the
   * default choice when multiple beans of the same type exist.
   * <p>
   * This test retrieves one User bean explicitly by name and another implicitly by type.
   * Both should refer to the same instance because the named bean is marked as @Primary.
   */
  @Test
  void linkShortenerPrimaryBeanTest(){
    ApplicationContext linkShortenerApplicationContext =
        new AnnotationConfigApplicationContext(LinkShortenerConfiguration.class);

    User user1 = linkShortenerApplicationContext.getBean("firstUser", User.class);
    User user2 = linkShortenerApplicationContext.getBean(User.class);

    Assertions.assertEquals(user1, user2);
  }

  @Test
  void linkShortenerSingletonBeanIsNotThreadSafe() throws InterruptedException {
    ApplicationContext linkShortenerApplicationContext =
        new AnnotationConfigApplicationContext(LinkShortenerConfiguration.class);

    User user1 = linkShortenerApplicationContext.getBean("firstUser", User.class);

    int numOfThreads = 1000;
    Thread[] threads = new Thread[numOfThreads];

    for (int i = 0; i < numOfThreads; i++) {
      threads[i] = new Thread(user1::increaseShortenerCount);
      threads[i].start();
    }

    for (Thread thread : threads) {
      thread.join();
    }

    System.out.println(user1.getShortenerCount());
    Assertions.assertNotEquals(100, user1.getShortenerCount());
  }


}
