package com.netflix.comprapacote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.comprapacote.dto.CompraDto;
import com.netflix.comprapacote.dto.InfoUsuarioDTO;

@Service
public class CompraPacoteService {

	@Autowired
	private RestTemplate cliente;

	public void realizaCompra(CompraDto compra) {
		ResponseEntity<InfoUsuarioDTO> exchange = cliente.exchange("http://cliente/info/" + compra.getItens(),
				HttpMethod.GET, null, InfoUsuarioDTO.class);
	}


}
