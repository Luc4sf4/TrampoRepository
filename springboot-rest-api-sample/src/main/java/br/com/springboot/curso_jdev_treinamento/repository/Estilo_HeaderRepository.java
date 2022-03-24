package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Estilo_Header;

@Repository
public interface Estilo_HeaderRepository extends JpaRepository<Estilo_Header, Long> {

	@Query(value = "select u from Estilo_Header where upper (trim(u.propriedade)) like %?1%")
	List<Estilo_Header> getEsitloHeader(String propriedade);
	
	
}
