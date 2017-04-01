package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Filo;

public class FiloDao extends Dao {
	private Connection connection;

	public void adiciona(Filo filo) throws SQLException {

		// Script SQL
		String sql = "insert into filo" + " (Nome,ID_Reino) " + " values (?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		// Preenche os valores

		stmt.setString(1, filo.getNome());
		stmt.setInt(2, filo.getReino().getId());

		// Executa
		stmt.execute();
		stmt.close();
		System.out.println("Filo salvo com sucesso!");
		super.getConexao().close();
	}

	public List<Filo> buscaTodosFilos() throws SQLException {
		List<Filo> filos = new ArrayList<>();
		String sql = "select * from filo";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Genero
			Filo filo = new Filo();
			filo.setId(rs.getInt("id"));
			filo.setNome(rs.getString("nome"));

			// Adicionando objeto a lista
			filos.add(filo);
		}
		rs.close();
		stmt.close();
		return filos;

	}

	public void altera(Filo filo) {
		String sql = "update filo set nome=?, ID_Reino=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, filo.getNome());
			stmt.setInt(2, filo.getReino().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Filo filo) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from filo where id=?");
			stmt.setLong(1, filo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
