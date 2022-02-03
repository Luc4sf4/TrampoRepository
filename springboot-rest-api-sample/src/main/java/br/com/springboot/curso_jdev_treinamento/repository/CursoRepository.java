package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	@Query(value = "select u from Curso u where upper(trim(u.nome)) like %?1%")
	List<Curso>getEveryCurso(String nome);
	

}
