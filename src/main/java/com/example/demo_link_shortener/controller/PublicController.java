package com.example.demo_link_shortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo_link_shortener.exception.PageNotFoundException;
import com.example.demo_link_shortener.repository.LinkRepository;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PublicController {

  private final LinkRepository linkRepository;

  @GetMapping
  public String getMainPage(Model model) {
    model.addAttribute("name", "Moto");
    return "main";
  }

  @GetMapping("/s/{id}")
  public ModelAndView getRedirectionView(@PathVariable("id") String id) {
    return linkRepository.findById(id)
      .map(link -> {
        ModelAndView modelAndView = new ModelAndView("redirect:" + link.getUrl());
        modelAndView.setStatus(HttpStatus.TEMPORARY_REDIRECT);
        return modelAndView;
      })
      .orElseGet(() -> {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
      });
  }

  @GetMapping(value = "/r/{id}")
  public void getRedirection(@PathVariable("id") String id, HttpServletResponse httpServletResponse) {
    linkRepository.findById(id)
      .ifPresentOrElse(link -> {
        httpServletResponse.setHeader("Location", link.getUrl());
        httpServletResponse.setStatus(302);
      }, () -> {
        throw new PageNotFoundException();
      });
  }
}
