package com.netflix.filme.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.filme.producer.FilmeProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping(value = "/ordemfilme")
@Slf4j
public class FilmeController {

	private final FilmeProducer filmeProducer;
	
	private static final Logger logger = LogManager.getLogger(FilmeController.class);

	private FilmeController(FilmeProducer filmeProducer) {
		this.filmeProducer = filmeProducer;
	}

	@RequestMapping(method = RequestMethod.POST)
	@CacheEvict
	public void send(@RequestBody String ordemFilme) {
		filmeProducer.enviar(ordemFilme);
		logger.info("Mensagem do filme postada !");
	}

}
