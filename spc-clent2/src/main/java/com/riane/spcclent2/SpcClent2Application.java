package com.riane.spcclent2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpcClent2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpcClent2Application.class, args);
	}
}
