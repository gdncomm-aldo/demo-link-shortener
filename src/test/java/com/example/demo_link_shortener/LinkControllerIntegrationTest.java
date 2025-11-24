package com.example.demo_link_shortener;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.json.JsonCompareMode;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo_link_shortener.entity.Link;
import com.example.demo_link_shortener.repository.LinkRepository;

@SpringBootTest
@AutoConfigureMockMvc
class LinkControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private LinkRepository linkRepository;

  @BeforeEach
  void setup() {
    linkRepository.deleteAll();
    linkRepository.save(new Link("1", "https://www.blibli.com"));
    linkRepository.save(new Link("3", "https://www.bliblitiket.com"));
  }

  @AfterEach
  void tearDown() {
    linkRepository.deleteAll();
  }

  @Test
  void getAll_GivenValidRequest_ReturnExpectedResponse() throws Exception {
    mockMvc.perform(get("/links").accept(MediaType.APPLICATION_JSON))
      .andExpect(content().json("""
      [
         { "id": "1", "url": "https://www.blibli.com" },
         { "id": "3", "url": "https://www.bliblitiket.com" }
      ]
      """, JsonCompareMode.STRICT));
  }

  @Test
  void findById_GivenValidRequest_ReturnExpectedResponse() throws Exception {
    mockMvc.perform(get("/links/1").accept(MediaType.APPLICATION_JSON))
      .andExpect(content().json("""
      { "id": "1", "url": "https://www.blibli.com" }
      """, JsonCompareMode.STRICT));
  }

}
