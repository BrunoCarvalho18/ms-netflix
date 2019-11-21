package com.netflix.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.usuario.model.InfoCliente;

@Service
public class InfoNomeService {
	
	@Autowired
	private InfoRepository infoRepository;
	
	public InfoCliente getInfoNome(String nome) {
		return infoRepository.findByNome(nome);
	}

}
