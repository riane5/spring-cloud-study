package com.riane.spcclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpcClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpcClient2Application.class, args);
    }
}
