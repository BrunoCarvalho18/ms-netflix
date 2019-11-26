package com.netflix.filmelistener.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class FilmeConsumer {

	private static final Logger logger = LogManager.getLogger(FilmeConsumer.class);

	@KafkaListener(topics = "${filme.topico}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumer(final ConsumerRecord consumerRecord) {
		logger.info("key: " + consumerRecord.key());
		logger.info("Headers: " + consumerRecord.headers());
		logger.info("Partion: " + consumerRecord.partition());
		logger.info("Order: " + consumerRecord.value());
	}

}
