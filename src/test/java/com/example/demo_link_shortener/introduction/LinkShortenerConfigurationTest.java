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

  /**
   * 5. Singleton Bean is not Thread Safe
   * Demonstrates that a singleton Spring bean is not thread-safe
   * when it contains mutable shared state and no synchronization.
   *
   * This test runs multiple threads that update the same User
   * bean instance concurrently. Due to race conditions, the final
   * value is usually less than the expected number of updates,
   * proving that the singleton bean is not thread-safe.
   */
  @Test
  void linkShortenerSingletonBeanIsNotThreadSafe() throws InterruptedException {
    // Create Spring ApplicationContext
    ApplicationContext linkShortenerApplicationContext =
        new AnnotationConfigApplicationContext(LinkShortenerConfiguration.class);

    // Retrieve the singleton User bean (one shared instance)
    User user1 = linkShortenerApplicationContext.getBean("firstUser", User.class);

    int numOfThreads = 1000;
    Thread[] threads = new Thread[numOfThreads];

    // Start 1000 threads that all update the same bean instance
    for (int i = 0; i < numOfThreads; i++) {
      threads[i] = new Thread(user1::increaseShortenerCount);
      threads[i].start();
    }

    // Wait for all threads to finish
    for (Thread thread : threads) {
      thread.join();
    }

    // Print the result to observe lost updates
    System.out.println(user1.getShortenerCount());

    // Expected value is 1000, but due to race conditions,
    // the actual value is usually less.
    Assertions.assertNotEquals(100, user1.getShortenerCount());
  }

  /**
   * 6. Prototype Bean
   * Verifies that a prototype-scoped bean creates a new instance
   * every time it is requested from the Spring ApplicationContext.
   * <p>
   * This test retrieves the same bean name twice and asserts that
   * the returned objects are different instances, proving that
   * prototype scope does not use singleton behavior.
   */
  @Test
  void linkShortenerPrototypeBeanTest(){
    ApplicationContext linkShortenerApplicationContext =
        new AnnotationConfigApplicationContext(LinkShortenerConfiguration.class);

    User user1 = linkShortenerApplicationContext.getBean("prototypeUser", User.class);
    User user2 = linkShortenerApplicationContext.getBean("prototypeUser", User.class);

    Assertions.assertNotEquals(user1, user2);
  }


}
