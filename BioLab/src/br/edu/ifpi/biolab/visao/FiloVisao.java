package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.FiloControle;
import br.edu.ifpi.biolab.controle.ReinoControle;
import br.edu.ifpi.biolab.entidade.Filo;
import br.edu.ifpi.biolab.entidade.Reino;

public class FiloVisao {
	private FiloControle filoControle;

	public FiloVisao() {
		filoControle = new FiloControle();
	}

	public static void main(String[] args) throws SQLException {
		FiloVisao visao = new FiloVisao();
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {

			String menu = " 1-Consultar \n 2-Adicionar \n 3-Alterar \n 4-Remover \n 0-Sair";

			String valorDigitado = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorDigitado);
			
			switch (opcaoEscolhida) {
			
			case 1:

				List<Filo> filos = visao.buscaTodosFilos();
				String filosTelas = "";
				for (Filo filo : filos) {
					filosTelas = filosTelas + filo.getId() + "-" + filo.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, filosTelas);

				break;
			case 2:
				String nomeFilo = JOptionPane.showInputDialog("Digite o nome do Filo.");
				Reino f = new Reino(opcaoEscolhida, nomeFilo);
				visao.adicionar(f);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
				break;
			case 3:
				
				break;
				
			case 4:
				
				break;

			}
		}
	}

	public void adicionar(Filo reino) throws SQLException {
		reinoControle.adiciona(reino);
	}

	public List<Filo> buscaTodosReino() throws SQLException {
		return reinoControle.buscaTodos();
	}

	public void altera(Filo reino) {
		reinoControle.altera(reino);

	}

	public void remove(Filo reino) {
		reinoControle.remove(reino);
	}
}
