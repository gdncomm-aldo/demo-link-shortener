package com.example.demo_link_shortener.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo_link_shortener.exception.DataNotFoundException;
import com.example.demo_link_shortener.exception.PageNotFoundException;

@ControllerAdvice
public class ErrorController {

  @ExceptionHandler(PageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFound(PageNotFoundException pageNotFoundException) {
    return "error";
  }

  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleNotFound(DataNotFoundException dataNotFoundException) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
      .body(Map.of("code", HttpStatus.NOT_FOUND.value(), "status", HttpStatus.NOT_FOUND.name()));
  }
}
