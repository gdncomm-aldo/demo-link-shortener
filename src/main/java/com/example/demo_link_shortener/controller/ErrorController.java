package com.example.demo_link_shortener.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleNotFound(
    MethodArgumentNotValidException methodArgumentNotValidException) {
    final Map<String, List<String>> errors = methodArgumentNotValidException.getBindingResult()
      .getFieldErrors()
      .stream()
      .collect(Collectors.groupingBy(
        FieldError::getField,
        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
      ));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
      .body(Map.of("code", HttpStatus.BAD_REQUEST.value(), "status", HttpStatus.BAD_REQUEST.name(), "errors", errors));
  }
}
