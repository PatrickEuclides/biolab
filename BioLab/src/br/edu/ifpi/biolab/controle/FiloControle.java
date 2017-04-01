package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.FiloDao;

import br.edu.ifpi.biolab.entidade.Filo;


public class FiloControle {
	private FiloDao filoDao;

	public FiloControle() {
		setFiloDao(new FiloDao());
	}

	public FiloDao getFiloDao() {
		return filoDao;
	}

	public void setFiloDao(FiloDao filoDao) {
		this.filoDao = filoDao;
	}

	public void adiciona(Filo filo) throws SQLException {
		filoDao.adiciona(filo);
		filoDao.fechaConexao();

	}
	public List<Filo> buscaTodos() throws SQLException{
		return filoDao.buscaTodosFilos();
	}
	public void altera(Filo filo) {
		filoDao.altera(filo);
		filoDao.fechaConexao();
	}

	public void remove(Filo filo) {
		filoDao.remove(filo);
		filoDao.fechaConexao();
	}
}
