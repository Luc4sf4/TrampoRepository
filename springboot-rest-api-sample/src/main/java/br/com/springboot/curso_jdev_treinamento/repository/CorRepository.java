package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Categoria;
import br.com.springboot.curso_jdev_treinamento.model.Cor;

@Repository
public interface CorRepository extends JpaRepository<Cor, Long>  {

		@Query (value = "select u from Cor u where upper(trim(u.description)) like %?1%")
		List<Cor> getCor(String description );
	
}
