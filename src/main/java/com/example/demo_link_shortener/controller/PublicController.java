package com.example.demo_link_shortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PublicController {

  @GetMapping
  public String getMainPage(Model model) {
    model.addAttribute("name", "Moto");
    return "main";
  }
}
