package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Estilo;
import br.com.springboot.curso_jdev_treinamento.model.Marca;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Long>{

	@Query (value = "select u from Estilo  u where upper(trim(u.description)) like %?1%")
	List<Estilo> getEstilo(String est);

	
	
}
