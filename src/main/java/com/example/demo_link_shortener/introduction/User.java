package com.example.demo_link_shortener.introduction;

import lombok.Data;

@Data
public class User {

  // Shared mutable state inside a singleton bean
  private int shortenerCount = 0;

  /**
   * Increases the counter in a non-thread-safe way.
   * <p>
   * This method intentionally separates the read and write operations
   * and introduces a delay to expose race conditions when accessed by multiple threads.
   */
  public void increaseShortenerCount(){
    // Step 1: Read the current value
    int temp = shortenerCount;

    // Step 2: Pause execution to increase chance of thread overlap
    try {
      Thread.sleep(1);
    } catch (InterruptedException ignored) {}

    // Step 3: Write the new value (may overwrite another thread's update)
    shortenerCount = temp + 1;
  }

}
