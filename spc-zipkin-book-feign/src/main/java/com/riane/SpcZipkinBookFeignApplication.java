package com.riane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
public class SpcZipkinBookFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcZipkinBookFeignApplication.class, args);
	}
}
