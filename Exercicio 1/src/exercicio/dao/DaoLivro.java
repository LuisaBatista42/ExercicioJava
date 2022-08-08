package exercicio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exercicio.entidades.Livro;
import exercicio.interfaces.ICrud;
import exercicio.utilidades.Conexao;

public class DaoLivro implements ICrud<Livro>{

	@Override
	public boolean salvar(Livro obj) {
		String sql = "insert into livro(titulo, autor) values(?,?)";
		Connection con = Conexao.conectar();
		try { 
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getTitulo());
			stm.setString(2, obj.getAutor());
			stm.execute();
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}

	@Override
	public boolean alterar(Livro obj) {
		String sql = "update livro set " +
				"titulo = ?,"+
				"autor = ? "+
				"where id = ?";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getTitulo());
			stm.setString(2, obj.getAutor());
			stm.setInt(3, obj.getId());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}

	@Override
	public void excluir(int id) {
		String sql = "delete from livro where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}		
	}

	@Override
	public Livro consultar(int id) {
		Livro contato = new Livro();
		String sql = "select * from livro where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if(rs.next()){
				contato.setId(rs.getInt("id"));
				contato.setTitulo(rs.getString("titulo"));
				contato.setAutor(rs.getString("autor"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}
		return contato;
	}

	@Override
	public List<Livro> consultar() {
		List<Livro> livros = new ArrayList<>();
		String sql = "select * from livro";
		
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				Livro livro = new Livro();
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livros.add(livro);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}
		return livros;
	}

}
