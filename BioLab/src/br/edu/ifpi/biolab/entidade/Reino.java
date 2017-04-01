package br.edu.ifpi.biolab.entidade;

public class Reino {

	private int ID;
	private String Nome;

	public Reino() {
	}

	public Reino(int id, String nome) {
		this.Nome = nome;
	}

	public int getid() {

		return ID;
	}

	public String getNome() {

		return Nome;
	}

	public int getId() {
		return ID;
	}

	public void setId(int iD) {
		this.ID = iD;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

}