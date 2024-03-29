package com.netflix.filme.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.filme.modelo.Filme;
import com.netflix.filme.producer.FilmeProducer;
import com.netflix.filme.repository.FilmeRepository;

@RestController
@RequestMapping(value = "/ordemfilme")
public class FilmeController {

	@Autowired
	private FilmeRepository filmerepository;

	private final FilmeProducer filmeProducer;

	private static final Logger logger = LogManager.getLogger(FilmeController.class);

	@PostMapping("/cadastro")
	@ResponseBody
	public ResponseEntity<Filme> cadastroFilme(@RequestBody @Valid Filme filme, BindingResult bindingResult) {
		filmerepository.save(filme);
		return new ResponseEntity<Filme>(HttpStatus.CREATED);

	}

	@GetMapping("/buscar/{nome}")
	public ResponseEntity<String> buscar(@PathVariable String nome) {
		Optional<String> cliente = filmerepository.buscarFilme(nome);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new String(cliente.get()));

		}

		return ResponseEntity.notFound().build();

	}

	@GetMapping("/assistir/{idFilme}/{idUsuario}")
	public void assistirFilme(@PathVariable Long idFilme, @PathVariable Long idUsuario) {
		send("Filme " + idFilme + " assistido pelo usuario " + idUsuario);
	}

	@GetMapping("/enfileirar/{idFilme}/{idUsuario}")
	public void enfileirarFilme(@PathVariable Long idFilme, @PathVariable Long idUsuario) {
		send("Filme " + idFilme + " enfileirado pelo usuario " + idUsuario);
	}

	@PutMapping("/classificar/{idFilme}/{classificacao}/{idUsuario}")
	public void classificarFilme(@PathVariable Long idFilme, @PathVariable int classificacao,
			@PathVariable Long idUsuario) {
		// TODO
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
