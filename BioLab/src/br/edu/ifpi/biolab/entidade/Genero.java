package br.edu.ifpi.biolab.entidade;

public class Genero {

	private int ID;
	private String Nome;
	private Familia familia;

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Genero() {

	}

	public Genero(int id, String nome) {
		this.Nome = nome;

	}

	public int getid() {

		return ID;
	}

	public String getNome() {

		return Nome;
	}

	public int getId() {

		return 0;
	}

	public void setNome(String string) {

	}

	public void setId(int int1) {

	}

}
