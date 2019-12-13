package com.howaboutliving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class HowaboutlivingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HowaboutlivingApplication.class, args);
	}

}
