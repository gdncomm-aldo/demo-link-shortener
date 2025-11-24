package com.example.demo_link_shortener.service;

public class Base36EncoderService implements EncoderService {

  @Override
  public String encode(long id) {
    return String.format("%6s", Long.toString(id, 36))
      .replace(' ', '0');
  }
}
