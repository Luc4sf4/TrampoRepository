package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Altura;

@Repository
public interface AlturaRepository extends JpaRepository<Altura, Long> {

	@Query (value = "select u from Altura u where upper(trim(u.description)) like %?1%")
	List<Altura> getAltura(String description);
	
		
}
