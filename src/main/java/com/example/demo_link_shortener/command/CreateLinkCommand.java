package com.example.demo_link_shortener.command;

import com.example.demo_link_shortener.command.model.CreateLinkCommandRequest;
import com.example.demo_link_shortener.command.model.CreateLinkCommandResponse;

public interface CreateLinkCommand extends Command<CreateLinkCommandRequest, CreateLinkCommandResponse> {
}
