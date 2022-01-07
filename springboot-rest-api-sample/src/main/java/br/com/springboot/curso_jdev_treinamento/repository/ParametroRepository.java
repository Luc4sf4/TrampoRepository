package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Parametros;

@Repository
public interface ParametroRepository extends JpaRepository<Parametros, Long> {

	
	@Query (value = "select u from Parametros u where upper(trim(u.sitetitle)) like %?1%")
	List<Parametros>getEveryParametro(String sitetitle);
	
	
}
