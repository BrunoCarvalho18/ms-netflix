package com.netflix.usuario.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.usuario.model.InfoCliente;
import com.netflix.usuario.service.InfoNomeService;
import com.netflix.usuario.service.InfoRepository;

@RestController
@RequestMapping("/info")
public class InfoUsuarioController {

	@Autowired
	private InfoNomeService infonomeservice;
	
	@Autowired
	private InfoRepository infonomerepository;
	

	@GetMapping("/{cliente}")
	public void getInfoNomeCliente(String cliente) {
		infonomeservice.getInfoNome(cliente);
	}

	@PostMapping("/cadastrousuario")
	public ResponseEntity<InfoCliente> cadastarCliente(@RequestBody @Valid InfoCliente cliente,
			BindingResult bindingResult) {
		infonomerepository.save(cliente);
		return new ResponseEntity<InfoCliente>(HttpStatus.CREATED);
	}

}
