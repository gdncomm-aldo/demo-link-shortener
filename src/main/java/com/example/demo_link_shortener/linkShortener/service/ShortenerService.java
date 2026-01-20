package com.example.demo_link_shortener.linkShortener.service;

/**
 * Defines the contract for URL shortening logic.
 * <p>
 * This allows multiple implementations to be injected
 * without changing the dependent class.
 */
public interface ShortenerService {

  void runShortener();

}
