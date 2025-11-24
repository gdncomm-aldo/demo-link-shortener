package com.example.demo_link_shortener.command.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetAllLinkCommandResponse {

  public List<Link> data;

  @NoArgsConstructor
  @AllArgsConstructor
  @Data
  @Builder
  public static final class Link {
    private String id;
    private String url;
  }
}
