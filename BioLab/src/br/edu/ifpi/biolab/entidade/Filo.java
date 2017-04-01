package br.edu.ifpi.biolab.entidade;

public class Filo {

	private int ID;
	private String Nome;
	private Reino reino;

	public Filo() {

	}

	public Filo(int id, String nome) {
		this.Nome = nome;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public void setReino(Reino reino) {
		this.reino = reino;
	}

	public Filo getReino() {

		return null;
	}
}