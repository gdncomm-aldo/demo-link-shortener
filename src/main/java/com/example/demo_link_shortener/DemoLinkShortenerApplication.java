package com.example.demo_link_shortener;

import com.example.demo_link_shortener.linkShortener.LinkShortener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Application entry point.
 *
 * Starts the Spring context and retrieves a LinkShortener bean
 * to demonstrate how @Qualifier overrides @Primary when
 * selecting a dependency.
 */
@SpringBootApplication
public class DemoLinkShortenerApplication {

	public static void main(String[] args) {
    ApplicationContext applicationContext =
        SpringApplication.run(DemoLinkShortenerApplication.class, args);

    LinkShortener linkShortener = applicationContext.getBean(LinkShortener.class);

    //this method will run base46 since the @Qualifier is reference to Base64 bean
    linkShortener.getShortenerService().runShortener();
	}

}
