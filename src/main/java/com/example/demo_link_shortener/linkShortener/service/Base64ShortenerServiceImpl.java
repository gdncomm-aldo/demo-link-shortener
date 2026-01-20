package com.example.demo_link_shortener.linkShortener.service;

import com.example.demo_link_shortener.linkShortener.properties.ShortenerProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Base64 implementation of ShortenerService.
 *
 * This service demonstrates injecting configuration properties
 * into a business component.
 */
@Service
@RequiredArgsConstructor
public class Base64ShortenerServiceImpl implements ShortenerService {

  private final ShortenerProperties shortenerProperties;

  @Override
  public void runShortener() {
    System.out.println("link shortener will use " + shortenerProperties.getComplex());
  }
}
