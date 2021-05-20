package net.spaceflightnewsapi.parsing_news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ParsingNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParsingNewsApplication.class, args);
	}
}
