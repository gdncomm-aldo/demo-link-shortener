package com.example.demo_link_shortener.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo_link_shortener.service.Base36EncoderService;
import com.example.demo_link_shortener.service.EncoderService;

@Configuration
public class BeanConfiguration {

  @Bean
  public EncoderService encoderService() {
    return new Base36EncoderService();
  }
}
