package com.example.demo_link_shortener;

import com.example.demo_link_shortener.linkShortener.LinkShortener;
import com.example.demo_link_shortener.linkShortener.properties.ShortenerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

/**
 * Application entry point.
 *
 * Enables configuration properties and starts the Spring context
 * to demonstrate injecting external configuration into beans.
 */
@SpringBootApplication
@EnableConfigurationProperties({ShortenerProperties.class})
public class DemoLinkShortenerApplication {

	public static void main(String[] args) {
    ApplicationContext applicationContext =
        SpringApplication.run(DemoLinkShortenerApplication.class, args);

    LinkShortener linkShortener = applicationContext.getBean(LinkShortener.class);

    //this method will run base46 since the @Qualifier is reference to Base64 bean
    linkShortener.getShortenerService().runShortener();
	}

}
