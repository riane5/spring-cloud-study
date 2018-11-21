package com.riane.spceurekaservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpcEurekaService2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpcEurekaService2Application.class, args);
	}
}
