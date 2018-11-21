package com.riane.spceurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpcEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcEurekaClientApplication.class, args);
    }
}
