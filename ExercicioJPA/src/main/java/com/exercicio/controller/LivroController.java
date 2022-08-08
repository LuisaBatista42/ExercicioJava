package com.exercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercicio.entidades.Livro;
import com.exercicio.repository.LivroRepository;

@Controller
@RequestMapping("/")
public class LivroController {
	
	@Autowired
	private LivroRepository repo;

	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String formCadastro() {
		return "cadastro";
	}
	
	@GetMapping("/consulta")
	public String formConsulta(Model model) {
		Iterable<Livro> listaLivro = repo.findAll();
		model.addAttribute("livros", listaLivro);
		return "consulta";
	}
	
	@GetMapping("/consulta/{idlivro}")
	public String formEditar(@PathVariable("idlivro") int id, Model model) {
		Livro livro = repo.findById(id).get();
		model.addAttribute("livro", livro);
		return "edicao";
	}
	
	@PostMapping("/cadastro")
	public String salvar(Livro livro) {
		repo.save(livro);
		return "redirect:/consulta";
	}
	
	@GetMapping("/delete/{idlivro}")
	public String delete(@PathVariable("idlivro") int id) {
		repo.deleteById(id);
		return "redirect:/consulta";
	}
}
