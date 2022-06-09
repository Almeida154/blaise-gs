package br.com.blaise;

import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {
		while (true) {
			int option = Integer.parseInt(JOptionPane.showInputDialog(
					"| Seja bem-vindo a Blaise :)"
					+ "\n| Escolha uma opção de objeto para ser instanciado!"
					+ "\n\n0 - Sair do programa"
					+ "\n1 - Instanciar fabricante"
					+ "\n2 - Instanciar fornecedor"
					+ "\n3 - Instanciar Produto"
					+ "\n4 - Instanciar ameaca"
					+ "\n5 - Instanciar teste"
					+ "\n\n"
					));
			if (option == 0) break;
			
			if (option == 1) {
				String cnpj = JOptionPane.showInputDialog("Digite o CNPJ da empresa");
				String nome = JOptionPane.showInputDialog("Digite o nome da empresa");
				String seguimento = JOptionPane.showInputDialog("Digite o seguimento da empresa");
				int produtosOferecidosQtnd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produtos diferentes que essa empresa oferece"));
				
				Fabricante manufacturer = new Fabricante(cnpj, nome, seguimento, produtosOferecidosQtnd);
				manufacturer.show();
				
			} else if (option == 2) {
				String cnpj = JOptionPane.showInputDialog("Digite o CNPJ da empresa");
				String nome = JOptionPane.showInputDialog("Digite o nome da empresa");
				String seguimento = JOptionPane.showInputDialog("Digite o seguimento da empresa");
				int marcasAdquiridasQntd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de marcas diferentes que essa empresa distribui"));
				
				Fornecedor provider = new Fornecedor(cnpj, nome, seguimento, marcasAdquiridasQntd);
				provider.show();
				
			} else if (option == 3) {
				String nome = JOptionPane.showInputDialog("Digite o nome do produto");
				String embalagem = JOptionPane.showInputDialog("Digite a embalagem do produto (Ex.: Plástico)");
				String fabricante = JOptionPane.showInputDialog("Digite o nome do fabricante do produto");
				String fornecedor = JOptionPane.showInputDialog("Digite o nome do fornecedor do produto");
				
				Produto product = new Produto(nome, embalagem, fabricante, fornecedor);
				product.show();
				
			} else if (option == 4) {
				String tipo = JOptionPane.showInputDialog("Digite o tipo da ameaça (Ex.: Clima, Praga...)");
				String nome = JOptionPane.showInputDialog("Digite o nome da ameaça");
				String descricao = JOptionPane.showInputDialog("Digite a descrição da ameaça");

				Ameaca threat = new Ameaca(tipo, nome, descricao);
				threat.show();
				
			} else if (option == 5) {
				String data = JOptionPane.showInputDialog("Digite a data do teste");
				String resultado = JOptionPane.showInputDialog("Digite o resultado do teste (se tiver)");
				String produto = JOptionPane.showInputDialog("Digite o produto testado");
				String ameaca = JOptionPane.showInputDialog("Digite a ameaça testada");

				Teste test = new Teste(data, resultado, produto, ameaca);
				test.show();
				
			} else {
				System.out.println("\n| Essa opção não existe!");
			}
		}
		System.out.println("\n| Obrigado por escolher a Blaise - Agrotech");
	}

}
