package com.example.demo_link_shortener.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo_link_shortener.service.IdGeneratorService;
import com.example.demo_link_shortener.service.InMemoryIdGeneratorService;

@Configuration
@ConditionalOnProperty(name = "config.id-generator.type", havingValue = "IN_MEMORY", matchIfMissing = true)
public class InMemoryIdGeneratorConfiguration {

  @Bean
  public IdGeneratorService idGeneratorService(@Value("${config.id-generator.seed:0}") Long seed) {
    return new InMemoryIdGeneratorService(seed);
  }

}
