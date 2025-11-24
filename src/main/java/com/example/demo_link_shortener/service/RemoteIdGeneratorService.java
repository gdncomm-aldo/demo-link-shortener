package com.example.demo_link_shortener.service;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import com.example.demo_link_shortener.exception.InternalServerErrorException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoteIdGeneratorService implements IdGeneratorService {

  private final RestClient restClient;

  @Override
  public long generateId() {
    final var response = restClient.get().uri("/generate-id")
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .toEntity(GenerateIdResponse.class);

    if (response.getStatusCode().isError() || response.getBody() == null) {
      throw new InternalServerErrorException("Error due http status " + response.getStatusCode());
    }
    return response.getBody().getId();
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @Data
  public static final class GenerateIdResponse {
    private long id;
  }
}
