package com.netflix.usuario.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.netflix.usuario.model.InfoCliente;

@Repository
public interface InfoRepository extends CrudRepository<InfoCliente,Long> {

	InfoCliente findByNome(String nome);
}

