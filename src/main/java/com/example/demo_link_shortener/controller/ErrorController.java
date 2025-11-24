package com.example.demo_link_shortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo_link_shortener.exception.PageNotFoundException;

@ControllerAdvice
public class ErrorController {

  @ExceptionHandler(PageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFound(PageNotFoundException pageNotFoundException) {
    return "error";
  }
}
