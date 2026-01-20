package com.example.demo_link_shortener.linkShortener;

import com.example.demo_link_shortener.linkShortener.service.ShortenerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Component that depends on ShortenerService.
 *
 * This class demonstrates constructor-based dependency injection
 * combined with @Qualifier for explicit implementation selection.
 */
@Component
@Getter
public class LinkShortener {

  /**
   * Dependency injected using @Qualifier.
   *
   * This explicitly selects the Base64 implementation,
   * even though another implementation is marked as @Primary.
   */
  private final ShortenerService shortenerService;

  public LinkShortener(@Qualifier("base64ShortenerServiceImpl") ShortenerService shortenerService) {
    this.shortenerService = shortenerService;
  }

}
