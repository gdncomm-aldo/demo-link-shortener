package com.example.demo_link_shortener.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_link_shortener.command.CommandExecutor;
import com.example.demo_link_shortener.command.GetAllLinkCommand;
import com.example.demo_link_shortener.command.model.GetAllLinkCommandRequest;
import com.example.demo_link_shortener.controller.model.LinkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/links")
@RequiredArgsConstructor
public class LinkController {

  private final CommandExecutor commandExecutor;

  @GetMapping
  public List<LinkResponse> getAll() {
    final var response = commandExecutor.execute(GetAllLinkCommand.class, new GetAllLinkCommandRequest());
    return response.getData()
      .stream()
      .map(link -> new LinkResponse(link.getId(), link.getUrl()))
      .toList();
  }
}
