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

import br.com.springboot.curso_jdev_treinamento.model.Bairro;
import br.com.springboot.curso_jdev_treinamento.repository.BairroRepository;

@RestController
public class BairroController {

	@Autowired
	private BairroRepository bairroRepository;

	
	
	
	@PostMapping(value = "salvarBairro")
	@ResponseBody
	public ResponseEntity<Bairro> salvarBairro(@RequestBody Bairro bairro) {

		Bairro est = bairroRepository.save(bairro);

		return new ResponseEntity<Bairro>(est, HttpStatus.CREATED);
	}

	
	
	
	@DeleteMapping(value = "deleteBairro")
	@ResponseBody
	ResponseEntity<String> deleteBairro(@RequestParam Long id) /* Recebe os dados para salvar */ {

		bairroRepository.deleteById(id);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}

	
	
	@PutMapping(value = "atualizarBairro")
	@ResponseBody
	public ResponseEntity<?> atualizarBairro(@RequestBody Bairro esti) /* Recebe os dados para salvar */ {

		if (esti.getId() == null) {
			return new ResponseEntity<String>(" Id não foi informado para a atualização ", HttpStatus.OK);
		}

		Bairro est = bairroRepository.saveAndFlush(esti);

		return new ResponseEntity<Bairro>(est, HttpStatus.OK);
	}

	
	
	
	@GetMapping(value = "getBairroid")
	@ResponseBody
	public ResponseEntity<Bairro> getBairroid(@RequestParam(name = "id") Long id) /* Recebe os dados para consultar */ {

		Bairro id1 = bairroRepository.findById(id).get();

		return new ResponseEntity<Bairro>(id1, HttpStatus.OK);
	}

	
	
	
	@GetMapping(value = "getBairro")
	@ResponseBody
	public ResponseEntity<List<Bairro>> getBairro(
			@RequestParam(name = "bairro") String bairro) /* Recebe os dados para consultar */ {

		List<Bairro> est1 = bairroRepository.getBairro(bairro.trim().toUpperCase());

		return new ResponseEntity<List<Bairro>>(est1, HttpStatus.OK);
	}

	
	
	
	@GetMapping(value = "getEveryBairro")
	@ResponseBody
	public ResponseEntity<List<Bairro>> getEveryBairro() {

		List<Bairro> est1 = bairroRepository.findAll();/* executa a consulta do banco de dados */

		return new ResponseEntity<List<Bairro>>(est1, HttpStatus.OK);

	}

}
