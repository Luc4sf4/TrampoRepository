package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	
	
	@Query(value ="select u from Matricula u where upper(trim(u.numeroMatricula)) like %?1%")
	List<Matricula>getEveryMatricula(String numeroMatricula);
	

}
