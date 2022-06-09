package br.com.blaise;

public class Empresa {
	// Attributes
	private String cnpj;
	private String nome;
	private String seguimento;

	// Constructor
	public Empresa(String cnpj, String nome, String seguimento) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.seguimento = seguimento;
	}
	
	public Empresa() {};
	
	// Getters and Setters

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSeguimento() {
		return seguimento;
	}

	public void setSeguimento(String seguimento) {
		this.seguimento = seguimento;
	}
}
