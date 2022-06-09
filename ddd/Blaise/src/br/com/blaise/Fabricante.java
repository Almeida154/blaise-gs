package br.com.blaise;

public class Fabricante extends Empresa {
	// Attributes
	private int produtosOferecidosQtnd;

	// Constructor
	public Fabricante(String cnpj, String nome, String seguimento, int produtosOferecidosQtnd) {
		super(cnpj, nome, seguimento);
		this.produtosOferecidosQtnd = produtosOferecidosQtnd;
	}
	
	public Fabricante() {};
	
	// Methods
	public void show() {
		System.out.println("\n| INSTÂNCIA DE FABRICANTE");
		System.out.println("CNPJ: " + this.getCnpj());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Seguimento: " + this.getSeguimento());
		System.out.println("Quantidade de produtos que oferece: " + this.getProdutosOferecidosQtnd());
	}

	// Getters and Setters
	public int getProdutosOferecidosQtnd() {
		return produtosOferecidosQtnd;
	}

	public void setProdutosOferecidosQtnd(int produtosOferecidosQtnd) {
		this.produtosOferecidosQtnd = produtosOferecidosQtnd;
	}
}
