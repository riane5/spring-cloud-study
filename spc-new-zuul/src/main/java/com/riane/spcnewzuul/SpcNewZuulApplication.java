package com.riane.spcnewzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpcNewZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcNewZuulApplication.class, args);
	}
}
