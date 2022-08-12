package com.exercicio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.entidades.Livro;
import com.exercicio.repository.LivroRepository;


@RestController
@RequestMapping("/")
public class LivroController {
	
	@Autowired
	LivroRepository repo;

	@GetMapping
	public String index() {
		return "Index";
	}
	
	@GetMapping("/livros")
	public ResponseEntity<List<Livro>> getLivros() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Livro> livros = (List) repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(livros);
	}
	
	@GetMapping("/livros/{idlivro}")
	public ResponseEntity<Livro> getLivrosByID(@PathVariable("idlivro") Long idlivro) {
		Optional<Livro> livro = repo.findById(idlivro);
		return livro.isPresent() ? ResponseEntity.ok(livro.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/livros")
	public ResponseEntity<Livro> saveLivro(@RequestBody Livro livroBody) {
		Livro livro = repo.save(livroBody);
		return ResponseEntity.status(HttpStatus.CREATED).body(livro);
	}
	
	@DeleteMapping("/livros/{idlivro}")
	public ResponseEntity<Object> deleteLivro(@PathVariable("idlivro") Long idlivro) {
		repo.deleteById(idlivro);
		return ResponseEntity.noContent().build();
	}	
	
	@PutMapping("/livros/{idlivro}")
	public ResponseEntity<Livro> alteraLivro(@PathVariable("idlivro") Long idlivro,
			@RequestBody Livro livro) {
		return ResponseEntity.ok(repo.save(livro));
	}

}
