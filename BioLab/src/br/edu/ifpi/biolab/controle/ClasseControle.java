package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.ClasseDao;

import br.edu.ifpi.biolab.entidade.Classe;


public class ClasseControle {
	private ClasseDao classeDao;

	public ClasseControle() {
		setClasseDao(new ClasseDao());
	}

	public ClasseDao getClasseDao() {
		return classeDao;
	}

	public void setClasseDao(ClasseDao classeDao) {
		this.classeDao = classeDao;
	}

	public void adiciona(Classe classe) throws SQLException {
		classeDao.adiciona(classe);
		classeDao.fechaConexao();

	}
	public List<Classe> buscaTodos() throws SQLException{
		return classeDao.buscaTodasClasses();
	}
	public void altera(Classe classe) {
		classeDao.altera(classe);
		classeDao.fechaConexao();
	}

	public void remove(Classe classe) {
		classeDao.remove(classe);
		classeDao.fechaConexao();
	}
}
