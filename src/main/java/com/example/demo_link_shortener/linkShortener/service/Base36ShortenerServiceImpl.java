package com.example.demo_link_shortener.linkShortener.service;

import com.example.demo_link_shortener.linkShortener.properties.ShortenerProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Base36 implementation of ShortenerService.
 *
 * This service is marked as @Primary and also uses injected
 * configuration properties.
 */
@Service
@Primary
@RequiredArgsConstructor
public class Base36ShortenerServiceImpl implements ShortenerService {

  private final ShortenerProperties shortenerProperties;

  @Override
  public void runShortener() {
    System.out.println("link shortener will use " + shortenerProperties.getBasic());
  }
}
