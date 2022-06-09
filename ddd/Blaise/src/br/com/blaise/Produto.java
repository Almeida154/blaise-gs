package br.com.blaise;

public class Produto {
	// Attributes
	private String nome;
	private String embalagem;
	private String fabricante;
	private String fornecedor;
	
	// Constructor
	public Produto(String nome, String embalagem, String fabricante, String fornecedor) {
		super();
		this.nome = nome;
		this.embalagem = embalagem;
		this.fabricante = fabricante;
		this.fornecedor = fornecedor;
	}

	// Getters and Setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmbalagem() {
		return embalagem;
	}
	
	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
}
