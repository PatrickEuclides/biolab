package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.GeneroDao;

import br.edu.ifpi.biolab.entidade.Genero;

public class GeneroControle {
	private GeneroDao generoDao;

	public GeneroControle() {
		setGeneroDao(new GeneroDao());
	}

	public GeneroDao getGeneroDao() {
		return generoDao;
	}

	public void setGeneroDao(GeneroDao generoDao) {
		this.generoDao = generoDao;
	}

	public void adiciona(Genero genero) throws SQLException {
		generoDao.adiciona(genero);
		generoDao.fechaConexao();

	}
	public List<Genero> buscaTodos() throws SQLException{
		return generoDao.buscaTodosGeneros();
	}
	public void altera(Genero genero) {
		generoDao.altera(genero);
		generoDao.fechaConexao();
	}

	public void remove(Genero genero) {
		generoDao.remove(genero);
		generoDao.fechaConexao();
	}
}
