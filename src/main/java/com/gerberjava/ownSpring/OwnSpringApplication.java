package com.gerberjava.ownSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class OwnSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwnSpringApplication.class, args);
	}
}
