package br.edu.ifpi.biolab.entidade;

public class Ordem {
	private String Nome;
	private int ID;
	private Classe classe;

	public Ordem() {

	}

	public Ordem(String nome, int id) {
		this.Nome = nome;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Ordem getClasse() {

		return null;
	}
}
