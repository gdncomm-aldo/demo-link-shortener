package com.example.demo_link_shortener.linkShortener.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Binds external configuration properties with prefix "architecture"
 * into a strongly typed Java object.
 *
 * This class enables type-safe access to application configuration.
 */
@Data
@Component
@ConfigurationProperties("architecture")
public class ShortenerProperties {
  private String basic;
  private String complex;
}
