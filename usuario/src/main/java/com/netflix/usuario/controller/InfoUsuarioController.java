package com.netflix.usuario.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.usuario.model.InfoCliente;
import com.netflix.usuario.service.InfoRepository;

@RestController
@RequestMapping("/api/v1/")
public class InfoUsuarioController {

	@Autowired
	private InfoRepository infoNomeRepository;

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<InfoCliente> getInfoNomeCliente(@PathVariable Long id) {
		Optional<InfoCliente> cliente = infoNomeRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new InfoCliente(cliente.get()));

		}

		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<InfoCliente> alterar(@PathVariable Long id, @Valid @RequestBody InfoCliente cliente) {
		if (!infoNomeRepository.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		cliente.setId(id);
		return ResponseEntity.ok(infoNomeRepository.save(cliente));

	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		Optional<InfoCliente> cliente = infoNomeRepository.findById(id);
		if (cliente.isPresent()) {
			infoNomeRepository.deleteById(id);
			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();

	}

	@PostMapping("/cadastro")
	@ResponseBody
	public ResponseEntity<InfoCliente> cadastarCliente(@RequestBody @Valid InfoCliente cliente,
			BindingResult bindingResult) {
		infoNomeRepository.save(cliente);
		return new ResponseEntity<InfoCliente>(HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	@HystrixCommand(fallbackMethod = "fallbackFalhou", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })

	private String fallbackFalhou() {
		return "Essa requisição falhou. Pode demorar para responder !";
	}
}
