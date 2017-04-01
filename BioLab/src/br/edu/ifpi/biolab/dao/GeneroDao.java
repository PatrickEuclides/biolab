package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Genero;

public class GeneroDao extends Dao {

	private Connection connection;

	public void adiciona(Genero genero) throws SQLException {

		// Script SQL
		String sql = "insert into genero" + " (Nome,ID_Familia) " + " values (?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		// Preenche os valores

		stmt.setString(1, genero.getNome());
		stmt.setInt(2, genero.getFamilia().getId());

		// Executa
		stmt.execute();
		stmt.close();
		System.out.println("Genero salvo com sucesso!");
		super.getConexao().close();
	}

	public List<Genero> buscaTodosGeneros() throws SQLException {
		List<Genero> generos = new ArrayList<>();
		String sql = "select * from genero";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Genero
			Genero genero = new Genero();
			genero.setId(rs.getInt("id"));
			genero.setNome(rs.getString("nome"));

			// Adicionando objeto a lista
			generos.add(genero);
		}
		rs.close();
		stmt.close();
		return generos;

	}

	public void altera(Genero genero) {
		String sql = "update genero set nome=?, email=?, endereco=?," + "dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, genero.getNome());
			stmt.setInt(2, genero.getFamilia().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Genero genero) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from genero where id=?");
			stmt.setLong(1, genero.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
