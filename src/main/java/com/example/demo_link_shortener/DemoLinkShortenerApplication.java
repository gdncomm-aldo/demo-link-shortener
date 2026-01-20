package com.example.demo_link_shortener;

import com.example.demo_link_shortener.linkShortener.LinkShortener;
import com.example.demo_link_shortener.linkShortener.service.ShortenerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Application entry point.
 *
 * Starts the Spring context and retrieves a LinkShortener bean
 * to demonstrate how Spring chooses a dependency when multiple
 * implementations exist.
 *
 * In this case, Spring will inject the implementation marked
 * with @Primary.
 */
@SpringBootApplication
public class DemoLinkShortenerApplication {

	public static void main(String[] args) {
    ApplicationContext applicationContext =
        SpringApplication.run(DemoLinkShortenerApplication.class, args);

    LinkShortener linkShortener = applicationContext.getBean(LinkShortener.class);

    //this method will run base46, then how to run using base 64?
    linkShortener.getShortenerService().runShortener();
	}

}
