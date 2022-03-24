package br.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev_treinamento.model.Estilo_Body;
import br.com.springboot.curso_jdev_treinamento.model.Estilo_Header;
import br.com.springboot.curso_jdev_treinamento.repository.Estilo_HeaderRepository;

@RequestMapping("header")
@RestController
public class Estilo_HeaderController {

	@Autowired
	private Estilo_HeaderRepository estilorepository;
	
	
	
	@PostMapping()
	@ResponseBody  
	public ResponseEntity<Estilo_Header> salvarEstilo(@RequestBody Estilo_Header est) /* Recebe os dados para salvar */ {

		Estilo_Header estilo = estilorepository.save(est);

		return new ResponseEntity<Estilo_Header>(estilo, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/id")
	@ResponseBody
	ResponseEntity<Estilo_Header> getEstiloHeaderId(@RequestParam(name = "id") Long id) {
		
		Estilo_Header id1= estilorepository.findById(id).get();
		
		return new ResponseEntity<Estilo_Header>(id1,HttpStatus.OK);
		
		
		
	} 
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Estilo_Header>>getEstilo(){
		
		List<Estilo_Header> esti= estilorepository.findAll();
		
		return new ResponseEntity<List<Estilo_Header>>(esti,HttpStatus.OK); 
		
	}
	
	@DeleteMapping
	@ResponseBody
	ResponseEntity<String> delteEstiloHeader(@RequestParam Long id){
		
		estilorepository.deleteById(id);
		
		return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
		
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateEstilo(@RequestBody Estilo_Header propriedade){
		
		
		if(propriedade.getId() == null) {
			
			return new ResponseEntity<String> ("id não informado para a autalização",HttpStatus.OK);
		}
		
		Estilo_Header est = estilorepository.saveAndFlush(propriedade);
		
		return new ResponseEntity<Estilo_Header>(est,HttpStatus.OK);		
	}
	
	
}
