package com.skilltracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SkillTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillTrackerApplication.class, args);
	}

}
