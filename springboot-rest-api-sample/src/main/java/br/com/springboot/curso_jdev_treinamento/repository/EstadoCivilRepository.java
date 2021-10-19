package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.EstadoCivil;
import br.com.springboot.curso_jdev_treinamento.model.Usuario;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> {
	
	@Query (value = "select u from EstadoCivil u where upper(trim(u.description)) like %?1%")
	List<EstadoCivil> getEstado(String description );

}
