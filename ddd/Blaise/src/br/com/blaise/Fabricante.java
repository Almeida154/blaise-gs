package br.com.blaise;

public class Fabricante extends Empresa {
	// Attributes
	private String produtosOferecidosQtnd;

	// Constructor
	public Fabricante(String cnpj, String nome, String seguimento, String produtosOferecidosQtnd) {
		super(cnpj, nome, seguimento);
		this.produtosOferecidosQtnd = produtosOferecidosQtnd;
	}

	// Getters and Setters
	public String getProdutosOferecidosQtnd() {
		return produtosOferecidosQtnd;
	}

	public void setProdutosOferecidosQtnd(String produtosOferecidosQtnd) {
		this.produtosOferecidosQtnd = produtosOferecidosQtnd;
	}
}
