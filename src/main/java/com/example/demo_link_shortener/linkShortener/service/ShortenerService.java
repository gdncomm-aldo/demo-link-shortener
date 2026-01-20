package com.example.demo_link_shortener.linkShortener.service;

/**
 * Defines the contract for Link shortening behavior.
 *
 * Multiple implementations can exist and be injected
 * into dependent components.
 */
public interface ShortenerService {

  void runShortener();

}
