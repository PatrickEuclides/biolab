package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;


import br.edu.ifpi.biolab.dao.FamiliaDao;
import br.edu.ifpi.biolab.entidade.Familia;

public class FamiliaControle {
	private FamiliaDao familiaDao;

	public FamiliaControle() {
		setFamiliaDao(new FamiliaDao());
	}

	public FamiliaDao getFamiliaDao() {
		return familiaDao;
	}

	public void setFamiliaDao(FamiliaDao familiaDao) {
		this.familiaDao = familiaDao;
	}

	public void adiciona(Familia familia) throws SQLException {
		familiaDao.adiciona(familia);
		familiaDao.fechaConexao();

	}
	public List<Familia> buscaTodos() throws SQLException{
		return familiaDao.buscaTodasfamilias();
	}
	public void altera(Familia familia) {
		familiaDao.altera(familia);
		familiaDao.fechaConexao();
	}

	public void remove(Familia familia) {
		familiaDao.remove(familia);
		familiaDao.fechaConexao();
	}
}
