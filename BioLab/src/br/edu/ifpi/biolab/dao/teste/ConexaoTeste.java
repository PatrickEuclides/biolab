package br.edu.ifpi.biolab.dao.teste;


import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.biolab.dao.ConnectionFactory;

public class ConexaoTeste {

	public static void main(String[] args) throws SQLException {
		
		Connection con = ConnectionFactory.getConexao();
		System.out.println("conectado");
		con.close();
		
	}
	
}
