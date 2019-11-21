package com.netflix.comprapacote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.comprapacote.dto.CompraDto;
import com.netflix.comprapacote.service.CompraPacoteService;

@RestController
@RequestMapping("/api/v1")
public class CompraPacoteController {
	
	@Autowired
	private CompraPacoteService compraService;

	@GetMapping("/hello")
	@ResponseBody
	public String retornaMicroservico() {
		return "Microserviço está no ar !";
	}

	@PostMapping("/comprapacote")
	@ResponseBody
	public void realizaCompra(@RequestBody CompraDto compra) {
		compraService.realizaCompra(compra);
	}

}
