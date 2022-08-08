package exercicio;

import java.util.List;

import exercicio.dao.DaoLivro;
import exercicio.entidades.Livro;
import exercicio.utilidades.Conexao;


public class Exercicio {
	public static void main(String[] args) {
		System.out.println("olá, mundo!");
		
//		testaConexao();
//		testaCadastro();
//		testaConsultaUmLivro();
//		testaConsulta();
//		testaAlterar();
//		testaExcluir();

	}
	
	public static void testaConexao() {
		if(Conexao.conectar() != null) {
			System.out.println("Conectado!");
		} else {
			System.out.println("Erro ao conectar");
		}		
	}
	
	public static void testaCadastro() {
		DaoLivro dc = new DaoLivro();
		Livro l1 = new Livro("100 anos de solidão", "Gabriel Garcia Marquez");
		if(dc.salvar(l1)) {
			System.out.println("Livro cadastrado com sucesso!");
		}
		Livro l2 = new Livro("Orgulho e preconceito", "Jane Austen");
		if(dc.salvar(l2)) {
			System.out.println("Livro cadastrado com sucesso!");
		}
		Livro l3 = new Livro("O guia do mochileiro das galáxias", "Douglas Adams");
		if(dc.salvar(l3)) {
			System.out.println("Livro cadastrado com sucesso!");
	}
}

	public static void testaConsultaUmLivro() {
		DaoLivro dc = new DaoLivro();
		Livro livro = dc.consultar(2);
		System.out.println(livro);
	}
	
	public static void testaConsulta() {
		DaoLivro dc = new DaoLivro();
		List<Livro> livros = dc.consultar();
		System.out.println(livros);		
	}
	
	public static void testaAlterar() {
		DaoLivro dc = new DaoLivro();
		Livro livro = dc.consultar(3);

		livro.setTitulo("A mulher do viajante no tempo");
		livro.setAutor("Audrey Niffenegger");
		
		if(dc.alterar(livro)) {
			System.out.println("\nAlterado com sucesso!\n" + livro);
		}
	}

	public static void testaExcluir() {
		DaoLivro dc = new DaoLivro();
		Livro livro = dc.consultar(2);
		
		System.out.println(livro);
		
		dc.excluir(2);
		livro = dc.consultar(2);
		
		System.out.println(livro);
	}
}