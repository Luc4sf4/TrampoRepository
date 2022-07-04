package br.com.springboot.curso_jdev_treinamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev_treinamento.model.Funcionario;
import br.com.springboot.curso_jdev_treinamento.repository.FuncionarioRepository;

@RequestMapping("funcionario")
@RestController
public class FuncinárioController {

	@Autowired
	private FuncionarioRepository funRepository;
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Funcionario> saveFuncionario (@RequestBody Funcionario func){
		
	Funcionario funcionario = funRepository.save(func);
	
	return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);		
	}
	
	
	
	
}
