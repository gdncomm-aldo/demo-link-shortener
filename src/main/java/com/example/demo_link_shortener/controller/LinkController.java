package com.example.demo_link_shortener.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_link_shortener.command.CommandExecutor;
import com.example.demo_link_shortener.command.CreateLinkCommand;
import com.example.demo_link_shortener.command.GetAllLinkCommand;
import com.example.demo_link_shortener.command.model.CreateLinkCommandRequest;
import com.example.demo_link_shortener.command.model.GetAllLinkCommandRequest;
import com.example.demo_link_shortener.controller.model.LinkRequest;
import com.example.demo_link_shortener.controller.model.LinkResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/links")
@RequiredArgsConstructor
public class LinkController {

  private final CommandExecutor commandExecutor;

  @GetMapping
  public List<LinkResponse> getAll() {
    final var commandResponse = commandExecutor.execute(GetAllLinkCommand.class, new GetAllLinkCommandRequest());
    return commandResponse.getData()
      .stream()
      .map(link -> new LinkResponse(link.getId(), link.getUrl()))
      .toList();
  }

  @PostMapping
  public LinkResponse create(@RequestBody LinkRequest webRequest) {
    final var commandRequest = CreateLinkCommandRequest.builder()
      .url(webRequest.getUrl())
      .build();

    final var commandResponse = commandExecutor.execute(CreateLinkCommand.class, commandRequest);
    return LinkResponse.builder()
      .id(commandResponse.getId())
      .build();
  }
}
