package com.example.demo_link_shortener.command;

public interface CommandExecutor {
  <R, T> T execute(Class<? extends Command<R, T>> commandClass, R request);
}
