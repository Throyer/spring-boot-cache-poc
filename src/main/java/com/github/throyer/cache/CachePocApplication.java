package com.github.throyer.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class CachePocApplication {
	public static void main(String[] args) {
		SpringApplication.run(CachePocApplication.class, args);
	}
}
