package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Estilo_Body;

@Repository
public interface Estilo_BodyRepository extends JpaRepository<Estilo_Body, Long>   {

	@Query(value= "select u from Estilo_Body u where upper(trim(u.propiedade)) like %?1%")
	List<Estilo_Body> getEstiloBody(String propiedade);
}
