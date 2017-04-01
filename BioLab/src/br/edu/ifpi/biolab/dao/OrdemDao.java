package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Filo;
import br.edu.ifpi.biolab.entidade.Ordem;

public class OrdemDao extends Dao {
	private Connection connection;
	public void adiciona(Ordem ordem) throws SQLException {

		// Script SQL
		String sql = "insert into ordem" + " (Nome,ID_Classe) " + " values (?,?)";

		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		// Preenche os valores
		stmt.setString(1, ordem.getNome());
		stmt.setInt(2, ordem.getClasse().getId());

		// Executa
		stmt.execute();
		stmt.close();
		System.out.println("Ordem salvo com sucesso!");
		super.getConexao().close();
	}

	public List<Ordem> buscaTodosOrdens() throws SQLException {
		List<Ordem> ordem = new ArrayList<>();
		String sql = "select * from ordem";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Genero
			Ordem ordem1 = new Ordem();
			ordem1.setId(rs.getInt("id"));
			ordem1.setNome(rs.getString("nome"));

			// Adicionando objeto a lista
			ordem.add(ordem1);
		}
		rs.close();
		stmt.close();
		return ordem;

	}
	public void altera(Ordem ordem) { 
	     String sql = "update ordem set nome=?, ID_Classe=? where id=?"; 
	     try { 
	         PreparedStatement stmt = connection.prepareStatement(sql); 
	         stmt.setString(1, ordem.getNome());
	 		stmt.setInt(2, ordem.getClasse().getId());
	         stmt.execute(); 
	         stmt.close(); 
	     } catch (SQLException e) { 
	         throw new RuntimeException(e); 
	     } 
	 } 
	public void remove(Ordem ordem) { 
	     try { 
	         PreparedStatement stmt = connection 
	                 .prepareStatement("delete from ordem where id=?"); 
	         stmt.setLong(1, ordem.getId()); 
	         stmt.execute(); 
	         stmt.close(); 
	     } catch (SQLException e) { 
	         throw new RuntimeException(e); 
	     } 
	 } 

}
