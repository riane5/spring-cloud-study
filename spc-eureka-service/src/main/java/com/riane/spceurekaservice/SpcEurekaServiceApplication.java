package com.riane.spceurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpcEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcEurekaServiceApplication.class, args);
	}
}
