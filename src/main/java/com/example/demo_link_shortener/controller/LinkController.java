package com.example.demo_link_shortener.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.example.demo_link_shortener.exception.DataNotFoundException;
import com.example.demo_link_shortener.repository.LinkRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/links")
@RequiredArgsConstructor
public class LinkController {

  private final CommandExecutor commandExecutor;

  private final LinkRepository linkRepository;

  @GetMapping
  public List<LinkResponse> getAll() {
    final var commandResponse = commandExecutor.execute(GetAllLinkCommand.class, new GetAllLinkCommandRequest());
    return commandResponse.getData()
      .stream()
      .map(link -> new LinkResponse(link.getId(), link.getUrl()))
      .toList();
  }

  @PostMapping
  public LinkResponse create(@Valid @RequestBody LinkRequest webRequest) {
    final var commandRequest = CreateLinkCommandRequest.builder()
      .url(webRequest.getUrl())
      .build();

    final var commandResponse = commandExecutor.execute(CreateLinkCommand.class, commandRequest);
    return LinkResponse.builder()
      .id(commandResponse.getId())
      .build();
  }

  @GetMapping("/{id}")
  public LinkResponse findById(@PathVariable("id") String id) {
    return linkRepository.findById(id)
      .map(link -> new LinkResponse(link.getId(), link.getUrl()))
      .orElseThrow(()-> new DataNotFoundException());
  }
}
