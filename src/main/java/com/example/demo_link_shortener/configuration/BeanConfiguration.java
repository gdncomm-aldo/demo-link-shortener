package com.example.demo_link_shortener.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo_link_shortener.service.Base36EncoderService;
import com.example.demo_link_shortener.service.EncoderService;
import com.example.demo_link_shortener.service.IdGeneratorService;
import com.example.demo_link_shortener.service.InMemoryIdGeneratorService;

@Configuration
public class BeanConfiguration {

  @Bean
  public IdGeneratorService idGeneratorService() {
    return new InMemoryIdGeneratorService(1_000_000L);
  }

  @Bean
  public EncoderService encoderService() {
    return new Base36EncoderService();
  }
}
