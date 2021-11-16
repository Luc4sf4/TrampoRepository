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
import br.com.springboot.curso_jdev_treinamento.model.Categoria;
import br.com.springboot.curso_jdev_treinamento.repository.CategoriaRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping(value = "getcategoriaid")
	@ResponseBody
	public ResponseEntity<Categoria> getcategoriaid(
			@RequestParam(name = "iduser") Long id) /* Recebe os dados para consultar */ {

		Categoria id1 = categoriaRepository.findById(id).get();

		return new ResponseEntity<Categoria>(id1, HttpStatus.OK);
	}

	@GetMapping(value = "getEveryCategoria")
	@ResponseBody
	public ResponseEntity<List<Categoria>> getEveryCategoria() {

		List<Categoria> cat = categoriaRepository.findAll();/* executa a consulta do banco de dados */

		return new ResponseEntity<List<Categoria>>(cat, HttpStatus.OK);

	}

	@GetMapping(value = "getCategoria")
	@ResponseBody
	public ResponseEntity<List<Categoria>> getCategoria(
			@RequestParam(name = "cat") String cat) /* Recebe os dados para consultar */ {

		List<Categoria> usuario = categoriaRepository.getCategoria(cat.trim().toUpperCase());

		return new ResponseEntity<List<Categoria>>(usuario, HttpStatus.OK);
	}

	@PostMapping(value = "salvarCategoria")
	@ResponseBody
	public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) /* Recebe os dados para salvar */ {

		Categoria cat = categoriaRepository.save(categoria);

		return new ResponseEntity<Categoria>(cat, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "deleteCategoria")
	@ResponseBody
	ResponseEntity<String> deleteCategoria(@RequestParam Long id) /* Recebe os dados para salvar */ {

		categoriaRepository.deleteById(id);

		return new ResponseEntity<String>("User deletado com sucesso ", HttpStatus.OK);
	}

	@PutMapping(value = "atualizarCategoria")
	@ResponseBody
	public ResponseEntity<?> atualizarCategoria(@RequestBody Categoria categoria) /* Recebe os dados para salvar */ {

		if (categoria.getId() == null) {
			return new ResponseEntity<String>(" Id não foi informado para a atualização ", HttpStatus.OK);
		}

		Categoria cat = categoriaRepository.saveAndFlush(categoria);

		return new ResponseEntity<Categoria>(cat, HttpStatus.OK);
	}

}
