package com.netflix.filme.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.netflix.filme.modelo.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

	Optional<Filme> findByNome(String nome);
	
	@Query(value= "select detalhes from filme WHERE nome = (:nome)", nativeQuery= true)
    Optional<String> buscarFilme(@Param("nome") String nome);

}
