package com.riane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.riane.feign")
public class SpcInvokerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcInvokerFeignApplication.class, args);
	}
}
