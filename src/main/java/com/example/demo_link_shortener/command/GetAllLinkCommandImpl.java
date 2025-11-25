package com.example.demo_link_shortener.command;

import org.springframework.stereotype.Service;

import com.example.demo_link_shortener.command.model.GetAllLinkCommandRequest;
import com.example.demo_link_shortener.command.model.GetAllLinkCommandResponse;
import com.example.demo_link_shortener.repository.LinkRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetAllLinkCommandImpl implements GetAllLinkCommand {

  private final LinkRepository linkRepository;

  @Override
  public GetAllLinkCommandResponse execute(GetAllLinkCommandRequest commandRequest) {

    if (commandRequest == null) {
      throw new IllegalArgumentException("Command request cannot be null");
    }

    final var data = linkRepository.findAll()
      .stream()
      .map(link -> new GetAllLinkCommandResponse.Link(link.getId(), link.getUrl()))
      .toList();
    return GetAllLinkCommandResponse.builder()
      .data(data)
      .build();
  }
}
