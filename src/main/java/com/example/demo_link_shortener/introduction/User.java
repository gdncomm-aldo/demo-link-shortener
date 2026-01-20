package com.example.demo_link_shortener.introduction;

import lombok.Data;

@Data
public class User {

  private int shortenerCount = 0;

  public void increaseShortenerCount(){
    int temp = shortenerCount;
    try {
      Thread.sleep(1);
    } catch (InterruptedException ignored) {}
    shortenerCount = temp + 1;
  }

}
