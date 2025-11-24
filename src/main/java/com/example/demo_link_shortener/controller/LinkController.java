package com.example.demo_link_shortener.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_link_shortener.entity.Link;

@RestController
@RequestMapping("/links")
public class LinkController {

  @GetMapping
  public List<Link> getAll() {
    return List.of(new Link("1", "https://www.blibli.com"),
      new Link("2", "https://www.bliblitiket.com"));
  }
}
