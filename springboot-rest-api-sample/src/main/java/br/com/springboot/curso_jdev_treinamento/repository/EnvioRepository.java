package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.TipoEnvio;

@Repository
public interface EnvioRepository extends JpaRepository<TipoEnvio, Long> {
	
	
	@Query (value = "select u from TipoEnvio u where upper(trim(u.description)) like %?1%")
	List<TipoEnvio>getEnvio (String description);
	

}
