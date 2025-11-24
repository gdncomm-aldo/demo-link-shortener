package com.example.demo_link_shortener.service;

import java.util.concurrent.atomic.AtomicLong;

public class InMemoryIdGeneratorService implements IdGeneratorService {

  private final AtomicLong atomicLong;

  public InMemoryIdGeneratorService(long seed) {
    this.atomicLong = new AtomicLong(seed);
  }

  @Override
  public long generateId() {
    return atomicLong.incrementAndGet();
  }
}
