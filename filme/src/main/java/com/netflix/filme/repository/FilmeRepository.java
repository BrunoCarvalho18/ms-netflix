package com.netflix.filme.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netflix.filme.modelo.Filme;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Long> {

	Optional<Filme> findById(String nome);

}
