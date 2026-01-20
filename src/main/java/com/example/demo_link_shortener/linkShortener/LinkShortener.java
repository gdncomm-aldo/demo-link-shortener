package com.example.demo_link_shortener.linkShortener;

import com.example.demo_link_shortener.linkShortener.service.ShortenerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Component that depends on ShortenerService.
 * <p>
 * This class demonstrates field-based dependency injection,
 * where Spring injects the dependency directly into the field.
 */
@Component
@Getter
public class LinkShortener {

  @Autowired
  private ShortenerService shortenerService;

}
