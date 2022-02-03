package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Aluno;

@Repository
public interface AlunoRespository extends JpaRepository<Aluno, Long>{

	
	@Query(value= "select u from Aluno u where upper (trim(u.ra))like %?1%")
	List<Aluno>getEveryAluno(String ra);
	
}
