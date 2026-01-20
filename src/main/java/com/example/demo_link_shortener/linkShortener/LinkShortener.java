package com.example.demo_link_shortener.linkShortener;

import com.example.demo_link_shortener.linkShortener.service.ShortenerService;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * Main component that depends on ShortenerService.
 * <p>
 * This class demonstrates constructor-based dependency injection,
 * where Spring provides the required dependency automatically.
 */
@Component
@Getter
public class LinkShortener {

  private ShortenerService shortenerService;

  /**
   * Constructor used by Spring to inject the ShortenerService dependency.
   * <p>
   * This ensures the dependency is provided at object creation time.
   */
  public LinkShortener(ShortenerService shortenerService) {
    this.shortenerService = shortenerService;
  }

}
