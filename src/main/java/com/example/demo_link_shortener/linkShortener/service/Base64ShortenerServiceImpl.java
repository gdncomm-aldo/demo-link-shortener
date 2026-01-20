package com.example.demo_link_shortener.linkShortener.service;

import org.springframework.stereotype.Service;

/**
 * Base64 implementation of ShortenerService.
 *
 * This implementation is explicitly selected using @Qualifier.
 */
@Service
public class Base64ShortenerServiceImpl implements ShortenerService {

  @Override
  public void runShortener() {
    System.out.println("link shortener will use Base64");
  }
}
