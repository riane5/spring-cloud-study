package com.riane.spczipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SpcZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcZipkinServerApplication.class, args);
	}
}
