package com.example.demo_link_shortener.exception;

public class InternalServerErrorException extends RuntimeException{

  public InternalServerErrorException(String message) {
    super(message);
  }
}
