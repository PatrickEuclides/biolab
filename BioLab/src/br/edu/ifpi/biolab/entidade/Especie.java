package br.edu.ifpi.biolab.entidade;

import java.util.Date;

public class Especie {
	private int ID;
	private String Nome_Cientifico;
	private String Nome_Vulgar;
	private Genero genero;
	private Date Data_Inclusao;

	public Especie() {

	}

	public Especie(int id, String nomeCientifico, String nomeVulgar) {
		this.Nome_Cientifico = nomeCientifico;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public String getNomeCientifico() {
		return Nome_Cientifico;
	}

	public void setNomeCientifico(String nomeCientifico) {
		this.Nome_Cientifico = nomeCientifico;
	}

	public String getNomeVulgar() {
		return Nome_Vulgar;
	}

	public void setNomeVulgar(String nomeVulgar) {
		this.Nome_Vulgar = nomeVulgar;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Date getData_Inclusao() {
		return Data_Inclusao;
	}

	public void setData_Inclusao(Date data_Inclusao) {
		Data_Inclusao = data_Inclusao;
	}

}