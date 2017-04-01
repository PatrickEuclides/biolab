package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.ReinoDao;
import br.edu.ifpi.biolab.entidade.Reino;

public class ReinoControle {
	private ReinoDao reinoDao;

	public ReinoControle() {
		setReinodao(new ReinoDao());
	}

	public ReinoDao getReinodao() {
		return reinoDao;
	}

	public void setReinodao(ReinoDao reinodao) {
		this.reinoDao = reinodao;
	}

	public void adiciona(Reino reino) throws SQLException {
		reinoDao.adiciona(reino);
		reinoDao.fechaConexao();

	}

	public List<Reino> buscaTodos() throws SQLException {
		return reinoDao.buscaTodosReinos();
	}

	public void altera(Reino reino) {
		reinoDao.altera(reino);
		reinoDao.fechaConexao();
	}

	public void remove(Reino reino) {
		reinoDao.remove(reino);
		reinoDao.fechaConexao();
	}
}
