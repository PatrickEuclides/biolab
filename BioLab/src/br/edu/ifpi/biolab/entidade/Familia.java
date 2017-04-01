package br.edu.ifpi.biolab.entidade;

public class Familia {

	private String Nome;
	private int ID;
	private Ordem ordem;

	public Familia() {

	}

	public Familia(int id, String nome) {
		this.Nome = nome;
		this.ID = id;
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

	public Ordem getOrdem() {
		return ordem;
	}

	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}

	public Familia getFilo() {

		return null;
	}

}