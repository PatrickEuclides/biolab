package br.edu.ifpi.biolab.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Reino;

public class ReinoDao extends Dao {
	
	


	private Connection connection;
	
	public void adiciona(Reino reino) throws SQLException {

		// Script SQL
		String sql = "insert into Reino " +  " (nome) " + " values (?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		// Preenche os valores
		stmt.setString(1, reino.getNome());

		// Executa
		stmt.execute();
		stmt.close();
		System.out.println("Reino salvo com sucesso!");
	}

	public List<Reino> buscaTodosReinos() throws SQLException {
		List<Reino> reinos = new ArrayList<>();
		String sql = "select * from Reino";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Reino
			Reino reino = new Reino();
			reino.setId(rs.getInt("ID_Reino"));
			reino.setNome(rs.getString("nome"));

			// Adicionando objeto a lista
			reinos.add(reino);
		}
		rs.close();
		stmt.close();
		return reinos;

	}
	public void altera(Reino reino) { 
	     String sql = "update Reino set nome=? where id=?"; 
	     try { 
	         PreparedStatement stmt = connection.prepareStatement(sql); 
	         stmt.setString(1, reino.getNome());
	         stmt.execute(); 
	         stmt.close(); 
	     } catch (SQLException e) { 
	         throw new RuntimeException(e); 
	     } 
	 } 
	public void remove(Reino reino) { 
	     try { 
	         PreparedStatement stmt = connection 
	                 .prepareStatement("delete from Reino where id=?"); 
	         stmt.setLong(1, reino.getId()); 
	         stmt.execute(); 
	         stmt.close(); 
	     } catch (SQLException e) { 
	         throw new RuntimeException(e); 
	     } 
	 } 
}