package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	@Query(value = "select u from Turma u where upper(trim(u.horario)) like %?1%")
	List<Turma>getEveryTurma(String horario);
	

}
