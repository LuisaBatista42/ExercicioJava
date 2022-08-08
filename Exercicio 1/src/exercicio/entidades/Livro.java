package exercicio.entidades;

public class Livro {
	private int id;
	private String titulo;
	private String autor;
	
	public Livro() {
	}

	public Livro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "\n Livro: \n id: " + id + ", \n titulo: " + titulo + ", \n autor: " + autor + "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
