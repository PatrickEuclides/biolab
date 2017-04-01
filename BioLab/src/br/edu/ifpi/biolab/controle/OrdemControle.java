package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.OrdemDao;
import br.edu.ifpi.biolab.entidade.Ordem;


public class OrdemControle {
	private OrdemDao ordemDao;

	public OrdemControle() {
		setOrdemDao(new OrdemDao());
	}

	public OrdemDao getOrdemDao() {
		return ordemDao;
	}

	public void setOrdemDao(OrdemDao ordemDao) {
		this.ordemDao = ordemDao;
	}

	public void adiciona(Ordem ordem) throws SQLException {
		ordemDao.adiciona(ordem);
		ordemDao.fechaConexao();

	}
	public List<Ordem> buscaTodos() throws SQLException{
		return ordemDao.buscaTodosOrdens();
	}
	public void altera(Ordem ordem) {
		ordemDao.altera(ordem);
		ordemDao.fechaConexao();
	}

	public void remove(Ordem ordem) {
		ordemDao.remove(ordem);
		ordemDao.fechaConexao();
	}
}