package com.riane.spcturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
public class SpcTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcTurbineApplication.class, args);
	}
}
