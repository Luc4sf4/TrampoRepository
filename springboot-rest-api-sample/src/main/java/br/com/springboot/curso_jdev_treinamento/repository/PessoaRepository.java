package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Pessoas;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoas, Long> {

	@Query(value = "select u from Pessoas u where upper(trim(u.nome))like %?1%")
	List<Pessoas> getPessoa(String nome);
	
}
