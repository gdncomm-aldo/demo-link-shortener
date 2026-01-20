package com.example.demo_link_shortener.linkShortener;

import com.example.demo_link_shortener.linkShortener.service.ShortenerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Component that depends on ShortenerService.
 *
 * When multiple ShortenerService implementations exist,
 * Spring will inject the one marked as @Primary by default.
 */
@Component
@Getter
@RequiredArgsConstructor
public class LinkShortener {

  private final ShortenerService shortenerService;

}
