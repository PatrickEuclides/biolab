package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Classe;

public class ClasseDao extends Dao {
	private Connection connection;

	public void adiciona(Classe classe) throws SQLException {

		// Script SQL
		String sql = "insert into classe" + " (Nome, ID_Filo) " + " values (?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		// Preenche os valores

		stmt.setString(1, classe.getNome());
		stmt.setInt(2, classe.getFilo().getId());

		// Executa
		stmt.execute();
		stmt.close();
		System.out.println("Classe salva com sucesso!");
	}

	public List<Classe> buscaTodasClasses() throws SQLException {
		List<Classe> classes = new ArrayList<>();
		String sql = "select * from classe";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Classe
			Classe classe = new Classe();
			classe.setId(rs.getInt("id"));
			classe.setNome(rs.getString("nome"));

			// Adicionando objeto a lista
			classes.add(classe);
		}
		rs.close();
		stmt.close();
		return classes;

	}

	public void altera(Classe classe) {
		String sql = "update classe set nome=?,ID_Filo=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, classe.getNome());
			stmt.setInt(2, classe.getFilo().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Classe classe) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from classe where id=?");
			stmt.setLong(1, classe.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}