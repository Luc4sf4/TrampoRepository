package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Professor;

@Repository
public interface ProfessorRespository extends JpaRepository<Professor, Long> {

	@Query(value = "select u from Professor u where upper (trim(u.contato)) like %?1%")
	List<Professor>getEveryProfessor(String contato);
	
}
