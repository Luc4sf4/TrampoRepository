package br.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;

import javax.xml.ws.Response;

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

import br.com.springboot.curso_jdev_treinamento.model.Parametros;
import br.com.springboot.curso_jdev_treinamento.model.Usuario;
import br.com.springboot.curso_jdev_treinamento.repository.ParametroRepository;

@RestController
public class ParametroController {

	@Autowired
	private ParametroRepository paramRepository;

	@PostMapping(value = "salvarParametro")
	@ResponseBody
	public ResponseEntity<Parametros> salvarParametro(@RequestBody Parametros param) {

		Parametros param1 = paramRepository.save(param);

		return new ResponseEntity<Parametros>(param1, HttpStatus.CREATED);

	}

	@GetMapping(value = "getParametro")
	@ResponseBody
	public ResponseEntity<List<Parametros>> getEveryParametro() {

		List<Parametros> param1 = paramRepository.findAll();

		return new ResponseEntity<List<Parametros>>(param1, HttpStatus.OK);
	
	}
	
	@GetMapping(value= "buscarParametroid")
	@ResponseBody
	public ResponseEntity<Parametros> buscarParametroid (@RequestParam (name = "id") Long id){
		
		Parametros parametro = paramRepository.findById(id).get();
		
		return new ResponseEntity<Parametros>(parametro, HttpStatus.OK);
		
		
	}
	


	@DeleteMapping(value = "deleteParametro")
	@ResponseBody
	ResponseEntity<String> deleteParametro(@RequestParam Long id) {

		paramRepository.deleteById(id);

		return new ResponseEntity<String>("Parametro deletado com sucesso", HttpStatus.OK);

	}

	@PutMapping(value = "atualizarParam")
	@ResponseBody
	public ResponseEntity<?> autalizarParam(@RequestBody Parametros param) {

		if (param.getId() == null) {
			return new ResponseEntity<String>("Id não foi informado para atualização ", HttpStatus.OK);
		}

		Parametros param1 = paramRepository.saveAndFlush(param);
		return new ResponseEntity<Parametros>(param1, HttpStatus.OK);

	}

}
