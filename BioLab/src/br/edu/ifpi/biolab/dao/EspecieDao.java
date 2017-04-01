package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Especie;

public class EspecieDao extends Dao {

	private Connection connection;

	public void adiciona(Especie especie) throws SQLException {

		// script SQL
		String sql = "insert into especie" + " (Nome_Cientifico,Nome_Vulgar,ID_Genero, Data_Inclusao) "
				+ " values (?,?,?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		// preenche os valores
		stmt.setString(1, especie.getNomeVulgar());
		stmt.setString(2, especie.getNomeCientifico());
		stmt.setDate(3, new java.sql.Date(especie.getData_Inclusao().getTime()));
		stmt.setInt(4, especie.getGenero().getId());

		// executa
		stmt.execute();
		stmt.close();
		System.out.println("Especie salva com sucesso!");
		super.getConexao().close();
	}

	public List<Especie> buscaTodasEspecies() throws SQLException {
		List<Especie> especies = new ArrayList<>();
		String sql = "select * from especie";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Especie
			Especie especie = new Especie();
			especie.setId(rs.getInt("id"));
			especie.setNomeVulgar(rs.getString("nome_vulgar"));
			especie.setNomeCientifico(rs.getString("nome_cientifico"));

			// montando a data através do Calender
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_inclusao"));
			especie.setData_Inclusao(data.getTime());

			// adicionando o objeto a lista
			especies.add(especie);
		}
		rs.close();
		stmt.close();
		return especies;

	}

	public void altera(Especie especie) {
		String sql = "update especie set nome_vulgar=?, nome_cientifico=?," + "data_inclusao=?, ID=? where ID=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, especie.getNomeVulgar());
			stmt.setString(2, especie.getNomeCientifico());
			stmt.setDate(3, new java.sql.Date(especie.getData_Inclusao().getTime()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Especie especie) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from especie where id=?");
			stmt.setLong(1, especie.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
