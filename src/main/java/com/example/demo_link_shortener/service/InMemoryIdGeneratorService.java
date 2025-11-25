package com.example.demo_link_shortener.service;

public class InMemoryIdGeneratorService implements IdGeneratorService {

  private long counter;

  public InMemoryIdGeneratorService(long seed) {
    this.counter = seed;
  }

  @Override
  public long generateId() {
    return ++counter;
  }
}
