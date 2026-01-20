package com.example.demo_link_shortener.linkShortener;

import com.example.demo_link_shortener.linkShortener.service.ShortenerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Component that depends on ShortenerService.
 * <p>
 * This class demonstrates setter-based dependency injection,
 * where Spring injects the dependency after object creation.
 */
@Component
@Getter
public class LinkShortener {

  private ShortenerService shortenerService;

  @Autowired
  public void setShortenerService(ShortenerService shortenerService) {
    this.shortenerService = shortenerService;
  }

}
