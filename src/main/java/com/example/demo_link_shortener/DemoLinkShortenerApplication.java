package com.example.demo_link_shortener;

import com.example.demo_link_shortener.linkShortener.LinkShortener;
import com.example.demo_link_shortener.linkShortener.service.ShortenerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Application entry point.
 * <p>
 * Starts the Spring context and retrieves a LinkShortener bean
 * to demonstrate setter-based dependency injection.
 */
@SpringBootApplication
public class DemoLinkShortenerApplication {

	public static void main(String[] args) {
    ApplicationContext applicationContext =
        SpringApplication.run(DemoLinkShortenerApplication.class, args);

    LinkShortener linkShortener1 = applicationContext.getBean(LinkShortener.class);
    ShortenerService shortenerService1 = linkShortener1.getShortenerService();
    ShortenerService shortenerService2 = linkShortener1.getShortenerService();

    System.out.println("first shortenerService = " + shortenerService1);
    System.out.println("second shortenerService = " + shortenerService2);
	}

}
