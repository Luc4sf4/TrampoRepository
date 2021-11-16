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

import br.com.springboot.curso_jdev_treinamento.model.TipoEnvio;
import br.com.springboot.curso_jdev_treinamento.repository.EnvioRepository;

public class TipoEnvioController {

	@Autowired
	private EnvioRepository envioRepository;

	@PostMapping(value = "saveEnvio")
	@ResponseBody
	public ResponseEntity<TipoEnvio> saveEnvio(@RequestBody TipoEnvio envio) {

		TipoEnvio envio1 = envioRepository.save(envio);

		return new ResponseEntity<TipoEnvio>(envio1, HttpStatus.CREATED);

	}

	@GetMapping(value = "getEnvio")
	@ResponseBody
	public ResponseEntity<List<TipoEnvio>> getEnvio(@RequestParam(name = "envio") String envio) {

		List<TipoEnvio> env = envioRepository.getEnvio(envio.trim().toUpperCase());

		return new ResponseEntity<List<TipoEnvio>>(env, HttpStatus.OK);

	}

	@GetMapping(value = "getEveryEnvio")
	@ResponseBody
	public ResponseEntity<List<TipoEnvio>> getEveryEnvio() {

		List<TipoEnvio> id1 = envioRepository.findAll();

		return new ResponseEntity<List<TipoEnvio>>(id1, HttpStatus.OK);

	}

	@GetMapping(value = "getEnvioId")
	@ResponseBody
	public ResponseEntity<TipoEnvio> getEnvioId(@RequestParam(name = "id") Long id) {

		TipoEnvio id1 = envioRepository.findById(id).get();

		return new ResponseEntity<TipoEnvio>(id1, HttpStatus.OK);

	}

	@PutMapping(value = "updateEnvio")
	@ResponseBody
	public ResponseEntity<?> updateEnvio(@RequestBody TipoEnvio envio) {

		if (envio.getId() == null) {
			return new ResponseEntity<String>("ID não informado para a atualização", HttpStatus.OK);

		}

		TipoEnvio env = envioRepository.saveAndFlush(envio);

		return new ResponseEntity<TipoEnvio>(env,HttpStatus.OK);

	}

	
	@DeleteMapping (value = "deleteEnvio")
	@ResponseBody
	public ResponseEntity<String> deleteEnvio (@RequestParam Long id){
		
		
		envioRepository.deleteById(id);
		
		return new ResponseEntity<String> ("Envio deletado com sucesso ", HttpStatus.OK);
		
	}
	
	
	
	
	
}
