package com.riane.spbadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpbAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpbAdminApplication.class, args);
	}
}
