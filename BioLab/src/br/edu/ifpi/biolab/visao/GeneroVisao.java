package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.GeneroControle;
import br.edu.ifpi.biolab.controle.ReinoControle;
import br.edu.ifpi.biolab.entidade.Genero;
import br.edu.ifpi.biolab.entidade.Reino;

public class GeneroVisao {
	private GeneroControle generoControle;

	public GeneroVisao() {
		generoControle = new GeneroControle();
	}

	public static void main(String[] args) throws SQLException {
		GeneroVisao visao = new GeneroVisao();
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {

			String menu = " 1-Consultar \n 2-Adicionar \n 3-Alterar \n 4-Remover \n 0-Sair";

			String valorDigitado = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorDigitado);
			
			switch (opcaoEscolhida) {
			
			case 1:

				List<Genero> generos = visao.buscaTodosGeneros();
				String generosTelas = "";
				for (Genero genero : generos) {
					generosTelas = generosTelas + genero.getId() + "-" + genero.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, generosTelas);

				break;
			case 2:
				String nomeGenero = JOptionPane.showInputDialog("Digite o nome do Genero.");
				Genero g = new Genero(opcaoEscolhida, nomeGenero);
				visao.adicionar(g);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
				break;
			case 3:
				
				break;
				
			case 4:
				
				break;

			}
		}
	}

	public void adicionar(Genero genero) throws SQLException {
		generoControle.adiciona(genero);
	}

	public List<Genero> buscaTodosGeneros() throws SQLException {
		return generoControle.buscaTodos();
	}

	public void altera(Genero  genero) {
		generoControle.altera(genero);

	}

	public void remove(Genero  genero) {
		generoControle.remove(genero);
	}
}
