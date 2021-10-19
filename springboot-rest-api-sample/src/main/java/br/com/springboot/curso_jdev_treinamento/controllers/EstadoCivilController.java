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

import br.com.springboot.curso_jdev_treinamento.model.EstadoCivil;
import br.com.springboot.curso_jdev_treinamento.repository.EstadoCivilRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class EstadoCivilController {


	
	@Autowired
	private EstadoCivilRepository estadoRepository;
	


	@PostMapping(value = "salvarEstado")
	@ResponseBody  
	public ResponseEntity<EstadoCivil> salvarEstado(@RequestBody EstadoCivil estado) /* Recebe os dados para salvar */ {

		EstadoCivil est = estadoRepository.save(estado);

		return new ResponseEntity<EstadoCivil>(est, HttpStatus.CREATED);
	}
	
	

	@DeleteMapping(value = "deleteEstado")
	@ResponseBody  
	ResponseEntity<String> deleteEstado(@RequestParam Long id) /* Recebe os dados para salvar */ {

		estadoRepository.deleteById(id);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}
	
	

	@PutMapping(value = "atualizarEstado")
	@ResponseBody  
	public ResponseEntity<?> atualizarEstado(@RequestBody EstadoCivil estado) /* Recebe os dados para salvar */ {

		if (estado.getId() == null) {
			return new ResponseEntity<String>(" Id não foi informado para a atualização ", HttpStatus.OK);
		}

		EstadoCivil est = estadoRepository.saveAndFlush(estado);

		return new ResponseEntity<EstadoCivil>(est, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "getEstadoid")
	@ResponseBody  
	public ResponseEntity<EstadoCivil> getEstadoid (@RequestParam(name = "id") Long id) /* Recebe os dados para consultar */ {

		EstadoCivil id1 = estadoRepository.findById(id).get();

		return new ResponseEntity<EstadoCivil>(id1, HttpStatus.OK);
	}
	
	

	@GetMapping(value = "getEstado")
	@ResponseBody  
	public ResponseEntity<List<EstadoCivil>> getEstado (@RequestParam(name = "estado") String est) /* Recebe os dados para consultar */ {

		List<EstadoCivil> est1 = estadoRepository.getEstado(est.trim().toUpperCase());

		return new ResponseEntity<List<EstadoCivil>>(est1, HttpStatus.OK);
	}
	
	

	@GetMapping(value = "getEveryEstado")
	@ResponseBody
	public ResponseEntity<List<EstadoCivil>> getEveryEstado() {

		List<EstadoCivil> est1 = estadoRepository.findAll();/* executa a consulta do banco de dados */

		return new ResponseEntity<List<EstadoCivil>>(est1, HttpStatus.OK);

	}

	
}
