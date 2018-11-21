package com.riane.spcstreamrabbitconsumer;

import com.riane.spcstreamrabbitconsumer.service.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Consumer.class)
public class SpcStreamRabbitConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcStreamRabbitConsumerApplication.class, args);
	}
}
