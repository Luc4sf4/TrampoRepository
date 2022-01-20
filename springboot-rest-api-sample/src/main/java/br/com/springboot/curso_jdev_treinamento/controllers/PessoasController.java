package br.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev_treinamento.model.Pessoas;
import br.com.springboot.curso_jdev_treinamento.repository.PessoaRepository;

@RequestMapping("pessoa")
@RestController
public class PessoasController {

	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Pessoas>>getListEveryPessoa(@RequestParam (name = "pessoa") String pessoa){
		
		List<Pessoas> pessoas = pessoaRepository.findAll();
		
		return new ResponseEntity<List<Pessoas>>(pessoas, HttpStatus.OK);	
	}
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	public ResponseEntity<Pessoas> getListPessoaID (@RequestParam(name = "id") Long idPessoa) {
		
		Pessoas people = pessoaRepository.findById(idPessoa).get();
		
		return new ResponseEntity<Pessoas>(people, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
}
