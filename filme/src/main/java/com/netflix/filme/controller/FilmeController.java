package com.netflix.filme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/assistir/{idFilme}/{idUsuario}")
	public void assistirFilme (@PathVariable Long idFilme, @PathVariable Long idUsuario) {
		send("Filme "+idFilme+" assistido pelo usuario "+idUsuario);
	}
	
	@GetMapping("/enfileirar/{idFilme}/{idUsuario}")
	public void enfileirarFilme (@PathVariable Long idFilme, @PathVariable Long idUsuario) {
		send("Filme "+idFilme+" enfileirado pelo usuario "+idUsuario);
	}
	
	@PutMapping("/classificar/{idFilme}/{classificacao}/{idUsuario}")
	public void classificarFilme (@PathVariable Long idFilme, @PathVariable int classificacao, @PathVariable Long idUsuario) {
		//TODO
	}

	private FilmeController(FilmeProducer filmeProducer) {
		this.filmeProducer = filmeProducer;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void send(@RequestBody String ordemFilme) {
		filmeProducer.enviar(ordemFilme);
		logger.info("Mensagem do filme postada !");
	}

}
