package com.example.demo_link_shortener.introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LinkShortenerConfiguration {

  @Bean
  public User firstUser(){
    return new User();
  }

}
