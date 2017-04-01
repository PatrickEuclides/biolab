package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Familia;

public class FamiliaDao extends Dao {
	private Connection connection;

	public void adiciona(Familia familia) throws SQLException {

		// Script SQL
		String sql = "insert into familia" + " (Nome, ID_Ordem) " + " values (?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		// Preenche os valores

		stmt.setString(1, familia.getNome());
		stmt.setInt(2, familia.getFilo().getId());

		// Executa
		stmt.execute();
		stmt.close();
		System.out.println("Familia salva com sucesso!");
	}

	public List<Familia> buscaTodasfamilias() throws SQLException {
		List<Familia> familias = new ArrayList<>();
		String sql = "select * from familia";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Classe
			Familia familia = new Familia();
			familia.setId(rs.getInt("id"));
			familia.setNome(rs.getString("nome"));

			// Adicionando objeto a lista
			familias.add(familia);
		}
		rs.close();
		stmt.close();
		return familias;

	}

	public void altera(Familia familia) {
		String sql = "update familia set nome=?, ID_Filo=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, familia.getNome());
			stmt.setInt(2, familia.getFilo().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Familia familia) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from familia where id=?");
			stmt.setLong(1, familia.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
