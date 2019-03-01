package com.riane.spcsleuthclient11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpcSleuthClient11Application {

	public static void main(String[] args) {
		SpringApplication.run(SpcSleuthClient11Application.class, args);
	}

}

