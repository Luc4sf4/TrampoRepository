package br.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;
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
import br.com.springboot.curso_jdev_treinamento.model.Altura;
import br.com.springboot.curso_jdev_treinamento.repository.AlturaRepository;

@RestController
public class AlturaController {

	private AlturaRepository alturaRepository;
	

	@PostMapping(value = "salvarAltura")
	@ResponseBody
	public ResponseEntity<Altura> salvarAltura(@RequestBody Altura alt) {

		Altura altu = alturaRepository.save(alt);
		
		return new ResponseEntity<Altura>(altu, HttpStatus.CREATED);
	}

	

	@DeleteMapping(value = "deleteAltura")
	@ResponseBody
	ResponseEntity<String> deleteAltura(@RequestParam Long id)  {

		alturaRepository.deleteById(id);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}

	

	@PutMapping(value = "atualizarAltura")
	@ResponseBody
	public ResponseEntity<?> atualizarAltura (@RequestBody Altura altu) {

		if (altu.getId() == null) {
			return new ResponseEntity<String>(" Id não foi informado para a atualização ", HttpStatus.OK);
		}

		Altura est = alturaRepository.saveAndFlush(altu);

		return new ResponseEntity<Altura>(est, HttpStatus.OK);
	}

	

	@GetMapping(value = "getEveryAltura")
	@ResponseBody
	public ResponseEntity<List<Altura>> getEveryAltura() {

		List<Altura> est1 = alturaRepository.findAll();

		return new ResponseEntity<List<Altura>>(est1, HttpStatus.OK);

	}
	
	
	
	
	
	
	
	
	
}
