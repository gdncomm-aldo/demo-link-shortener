package com.example.demo_link_shortener.command;

import org.springframework.stereotype.Service;

import com.example.demo_link_shortener.command.model.CreateLinkCommandRequest;
import com.example.demo_link_shortener.command.model.CreateLinkCommandResponse;
import com.example.demo_link_shortener.entity.Link;
import com.example.demo_link_shortener.repository.LinkRepository;
import com.example.demo_link_shortener.service.EncoderService;
import com.example.demo_link_shortener.service.IdGeneratorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateLinkCommandImpl implements CreateLinkCommand {

  private final IdGeneratorService idGeneratorService;

  private final EncoderService encoderService;

  private final LinkRepository linkRepository;

  @Override
  public CreateLinkCommandResponse execute(CreateLinkCommandRequest commandRequest) {
    final var link = Link.builder()
      .id(encoderService.encode(idGeneratorService.generateId()))
      .url(commandRequest.getUrl())
      .build();
    final var savedLink = linkRepository.save(link);
    return CreateLinkCommandResponse.builder()
      .id(savedLink.getId())
      .build();
  }
}
