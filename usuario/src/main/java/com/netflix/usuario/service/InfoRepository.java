package com.netflix.usuario.service;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.netflix.usuario.model.InfoCliente;

@Repository
public interface InfoRepository extends CrudRepository<InfoCliente,Long> {

	Optional<InfoCliente> findById(Long id);
}

