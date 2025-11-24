package com.example.demo_link_shortener.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import com.example.demo_link_shortener.service.IdGeneratorService;
import com.example.demo_link_shortener.service.RemoteIdGeneratorService;

@Configuration
@ConditionalOnProperty(name = "config.id-generator.type", havingValue = "REMOTE")
public class RemoteIdGeneratorConfiguration {

  @Bean
  public RestClient remoteIdRestClient() {
    return RestClient.builder()
      .baseUrl("http://localhost:10001")
      .build();
  }

  @Bean
  public IdGeneratorService remoteIdGeneratorService(@Qualifier("remoteIdRestClient") RestClient restClient) {
    return new RemoteIdGeneratorService(restClient);
  }
}
