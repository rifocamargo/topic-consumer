package com.lecom.topicconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class TopicConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopicConsumerApplication.class, args);
	}

}
