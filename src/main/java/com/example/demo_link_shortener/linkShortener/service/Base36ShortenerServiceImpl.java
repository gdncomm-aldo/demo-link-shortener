package com.example.demo_link_shortener.linkShortener.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Base36 implementation of ShortenerService.
 *
 * This implementation is marked as @Primary and will be
 * selected by Spring when no qualifier is specified.
 */
@Service
@Primary
public class Base36ShortenerServiceImpl implements ShortenerService {

  @Override
  public void runShortener() {
    System.out.println("link shortener will use Base36");
  }
}
