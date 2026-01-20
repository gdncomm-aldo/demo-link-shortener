package com.example.demo_link_shortener.linkShortener.service;

import org.springframework.stereotype.Service;

/**
 * Default implementation of ShortenerService.
 * <p>
 * This bean is injected into dependent components
 * using field-based dependency injection.
 */
@Service
public class Base36ShortenerServiceImpl implements ShortenerService {

  @Override
  public void runShortener() {

  }
}
