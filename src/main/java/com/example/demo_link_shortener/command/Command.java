package com.example.demo_link_shortener.command;

public interface Command<R, T> {

  T execute(R commandRequest);
}
