package com.lecom.topicconsumer;

import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableConfigurationProperties(ActiveMQProperties.class)
public class ConsomerConfiguration {

	@Bean
	public ActiveMQConnectionFactory receiverActiveMQConnectionFactory(ActiveMQProperties activeMQProperties) {
		final ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(activeMQProperties.getBrokerUrl());
		activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.lecom"));
		return activeMQConnectionFactory;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
			ActiveMQConnectionFactory activeMQConnectionFactory, TopicConsomerProperties topicConsomerProperties) {
		final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(activeMQConnectionFactory);
		factory.setPubSubDomain(true);
		factory.setClientId(topicConsomerProperties.getClientId());
		factory.setSubscriptionDurable(true);
		return factory;
	}
}
