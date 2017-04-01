package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.OrdemControle;
import br.edu.ifpi.biolab.entidade.Familia;
import br.edu.ifpi.biolab.entidade.Ordem;
import br.edu.ifpi.biolab.entidade.Reino;

public class OrdemVisao {
	
		private OrdemControle ordemControle;

		public OrdemVisao() {
			ordemControle = new OrdemControle();
		}

		public static void main(String[] args) throws SQLException {
			OrdemVisao visao = new OrdemVisao();
			int opcaoEscolhida = 1;
			while (opcaoEscolhida != 0) {

				String menu = " 1-Consultar \n 2-Adicionar \n 3-Alterar \n 4-Remover \n 0-Sair";

				String valorDigitado = JOptionPane.showInputDialog(menu);
				opcaoEscolhida = Integer.parseInt(valorDigitado);
				
				switch (opcaoEscolhida) {
				
				case 1:

					List<Ordem> ordem = visao.buscaTodosOrdem();
					String ordensTelas  = "";
					for (Ordem ordens : ordem) {
						ordensTelas = ordensTelas + ordens.getId() + "-" + ordens.getNome() + "\n";
					}
					JOptionPane.showMessageDialog(null, ordensTelas);

					break;
				case 2:
					String nomeOrdem= JOptionPane.showInputDialog("Digite o nome do Ordem.");
					Ordem o = new Ordem(opcaoEscolhida, nomeOrdem);
					visao.adicionar(o);
					JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
					break;
				case 3:
					
					break;
					
				case 4:
					
					break;

				}
			}
		}

		public void adicionar(Ordem ordem) throws SQLException {
			ordemControle.adiciona(ordem);
		}

		public List<Ordem> buscaTodosOrdem() throws SQLException {
			return ordemControle.buscaTodos();
		}

		public void altera(Ordem ordem) {
			ordemControle.altera(ordem);

		}

		public void remove(Ordem ordem) {
			ordemControle.remove(ordem);
		}
	}


