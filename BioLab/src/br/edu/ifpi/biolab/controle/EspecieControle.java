package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.EspecieDao;
import br.edu.ifpi.biolab.entidade.Especie;



public class EspecieControle {
	private EspecieDao especieDao;

	public EspecieControle() {
		setEspecieDao(new EspecieDao());
	}

	public EspecieDao getEspecieDao() {
		return especieDao;
	}

	public void setEspecieDao(EspecieDao especieDao) {
		this.especieDao = especieDao;
	}

	public void adiciona(Especie especie) throws SQLException {
		especieDao.adiciona(especie);
		especieDao.fechaConexao();

	}
	public List<Especie> buscaTodos() throws SQLException{
		return especieDao.buscaTodasEspecies();
	}
	public void altera(Especie especie) {
		especieDao.altera(especie);
		especieDao.fechaConexao();
	}

	public void remove(Especie especie) {
		especieDao.remove(especie);
		especieDao.fechaConexao();
	}
}
