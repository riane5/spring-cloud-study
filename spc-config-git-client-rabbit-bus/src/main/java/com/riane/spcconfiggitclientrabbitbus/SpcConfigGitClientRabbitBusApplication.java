package com.riane.spcconfiggitclientrabbitbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpcConfigGitClientRabbitBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcConfigGitClientRabbitBusApplication.class, args);
	}
}
