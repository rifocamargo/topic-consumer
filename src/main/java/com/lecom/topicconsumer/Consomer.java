package com.lecom.topicconsumer;

import javax.jms.MapMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consomer {
	private static final Logger LOGGER = LoggerFactory.getLogger(Consomer.class);

	@JmsListener(subscription = "${jms.topic}", destination = "${jms.topic}", selector = "${jms.selector}")
	public void receive(MapMessage message) {
		LOGGER.info("Received message='{}'", message);
	}
}
