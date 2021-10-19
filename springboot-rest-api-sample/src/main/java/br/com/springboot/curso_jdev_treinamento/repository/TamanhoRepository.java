package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.EstadoCivil;
import br.com.springboot.curso_jdev_treinamento.model.Tamanho;

@Repository
public interface TamanhoRepository extends JpaRepository<Tamanho, Long> {


	@Query (value = "select u from Tamanho u where upper(trim(u.description)) like %?1%")
	List<Tamanho> getEstado(String description);
	
	
	
}
