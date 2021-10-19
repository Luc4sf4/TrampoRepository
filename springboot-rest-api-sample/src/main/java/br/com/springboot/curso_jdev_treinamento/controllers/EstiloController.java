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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev_treinamento.model.Estilo;
import br.com.springboot.curso_jdev_treinamento.repository.EstiloRepository;

@RestController
public class EstiloController {


	@Autowired
	private EstiloRepository estiloRepository;
	

	
/*======================================================Estilo=======================================================================*/

	
	@PostMapping(value = "salvarEstilo")
	@ResponseBody  
	public ResponseEntity<Estilo> salvarEstilo(@RequestBody Estilo est) /* Recebe os dados para salvar */ {

		estiloRepository.save(est);

		return new ResponseEntity<Estilo>(est, HttpStatus.CREATED);
	}
	
	

	@DeleteMapping(value = "deleteEstilo")
	@ResponseBody  
	ResponseEntity<String> deleteEstilo(@RequestParam Long id) /* Recebe os dados para salvar */ {

		estiloRepository.deleteById(id);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}
	
	
	@PutMapping(value = "atualizarEstilo")
	@ResponseBody  
	public ResponseEntity<?> atualizarEstilo(@RequestBody Estilo esti) /* Recebe os dados para salvar */ {

		if (esti.getId() == null) {
			return new ResponseEntity<String>(" Id não foi informado para a atualização ", HttpStatus.OK);
		}

		Estilo est = estiloRepository.saveAndFlush(esti);

		return new ResponseEntity<Estilo>(est, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "getEstiloid")
	@ResponseBody  
	public ResponseEntity<Estilo> getEstiloid (@RequestParam(name = "id") Long id) /* Recebe os dados para consultar */ {

		Estilo id1 = estiloRepository.findById(id).get();

		return new ResponseEntity<Estilo>(id1, HttpStatus.OK);
	}
	
	

	@GetMapping(value = "getEstilo")
	@ResponseBody  
	public ResponseEntity<List<Estilo>> getEstilo (@RequestParam(name = "esti") String estilo) /* Recebe os dados para consultar */ {

		List<Estilo> est1 = estiloRepository.getEstilo(estilo.trim().toUpperCase());

		return new ResponseEntity<List<Estilo>>(est1, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "getEveryEstilo")
	@ResponseBody
	public ResponseEntity<List<Estilo>> getEveryEstilo() {

		List<Estilo> est1 = estiloRepository.findAll();/* executa a consulta do banco de dados */

		return new ResponseEntity<List<Estilo>>(est1, HttpStatus.OK);

	}

	
	
	
}
