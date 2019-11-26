package com.netflix.filme.producer;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class FilmeProducer {

	@Value("${filme.topico}")
	private String filmeTopico;

	private final KafkaTemplate<String, String> kafkaTemplate;

	public FilmeProducer(final KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void enviar(final @RequestBody String ordemFilme) {
		final String mensageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(filmeTopico, mensageKey, ordemFilme);
	}

	

}
