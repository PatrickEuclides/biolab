package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.FamiliaControle;
import br.edu.ifpi.biolab.entidade.Familia;
import br.edu.ifpi.biolab.entidade.Reino;


public class FamiliaVisao {
	private FamiliaControle familiaControle;

	public FamiliaVisao() {
		familiaControle = new FamiliaControle();
	}

	public static void main(String[] args) throws SQLException {
		FamiliaVisao visao = new FamiliaVisao();
		int opcaoEscolhida = 1;
		while (opcaoEscolhida != 0) {

			String menu = " 1-Consultar \n 2-Adicionar \n 3-Alterar \n 4-Remover \n 0-Sair";

			String valorDigitado = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorDigitado);
			
			switch (opcaoEscolhida) {
			
			case 1:

				List<Familia> familias = visao.buscaTodasfamilias();
				String familiasTelas = "";
				for (Familia familia : familias) {
					familiasTelas = familiasTelas + familia.getId() + "-" + familia.getNome() + "\n";
				}
				JOptionPane.showMessageDialog(null, familiasTelas);

				break;
			case 2:
				String nomeFamilia= JOptionPane.showInputDialog("Digite o nome do Familia.");
				
				Familia f = new Familia(opcaoEscolhida, nomeFamilia);
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

	public void adicionar(Familia familia) throws SQLException {
		familiaControle.adiciona(familia);
	}

	public List<Familia> buscaTodasfamilias() throws SQLException {
		return familiaControle.buscaTodos();
	}

	public void altera(Familia familia) {
		
		familiaControle.altera(familia);

	}

	public void remove(Familia familia) {
		familiaControle.remove(familia);
	}
}
