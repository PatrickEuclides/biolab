package br.edu.ifpi.biolab.entidade;

public class Classe {
	private String Nome;
	private Filo filo;
	private int ID;

	public Classe() {

	}

	public Classe(String nome, int id) {
		this.Nome = nome;
		this.ID = id;

	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public void setFilo(Filo filo) {
		this.filo = filo;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public Classe getFilo() {

		return null;
	}
}