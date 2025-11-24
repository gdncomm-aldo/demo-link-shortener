package com.example.demo_link_shortener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo_link_shortener.entity.Link;
import com.example.demo_link_shortener.repository.LinkRepository;

@SpringBootApplication
public class DemoLinkShortenerApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoLinkShortenerApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(LinkRepository linkRepository) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        linkRepository.save(new Link("1", "https://www.blibli.com"));
        linkRepository.save(new Link("2", "https://www.bliblitiket.com"));
      }
    };
  }
}
