package com.example.demo_link_shortener.linkShortener.service;

/**
 * Setter used by Spring to inject the ShortenerService dependency.
 * <p>
 * This allows the dependency to be changed after object creation,
 * but does not guarantee immutability or full initialization.
 */
public interface ShortenerService {

  void runShortener();

}
