package com.example.demo_link_shortener.linkShortener.service;

/**
 * Setter used by Spring to inject the ShortenerService dependency.
 * <p>
 * This allows multiple implementations to be injected
 * without changing the dependent class.
 */
public interface ShortenerService {

  void runShortener();

}
