package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.TurmaProfessor;

@Repository
public interface TurmaProfRespository extends JpaRepository<TurmaProfessor, Long>{

	@Query(value = "select m from TurmaProfessor m")/* não entendi como isso que isso ainda funciona, mas só funciona, por enquanto não deu erro */
	List<TurmaProfessor>getEveryTurmaProfessor(Long idTurmaProf);
	
	
}
