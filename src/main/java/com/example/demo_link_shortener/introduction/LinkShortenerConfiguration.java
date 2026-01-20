package com.example.demo_link_shortener.introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class LinkShortenerConfiguration {

  /**
   * Primary User bean.
   * This bean will be selected by default
   * when a User type is requested without a qualifier.
   */
  @Bean
  @Primary
  public User firstUser(){
    return new User();
  }

  /**
   * Secondary User bean.
   */
  @Bean
  public User secondUser(){
    return new User();
  }

  /**
   * Defines a prototype-scoped User bean.
   * <p>
   * Each request to the ApplicationContext for this bean
   * will return a new User instance, unlike singleton beans
   * which return the same instance every time.
   */
  @Bean
  @Scope("prototype")
  public User prototypeUser() {
    return new User();
  }

}
