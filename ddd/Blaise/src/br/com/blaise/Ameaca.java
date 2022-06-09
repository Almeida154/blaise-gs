package br.com.blaise;

public class Ameaca {
	// Attributes
	private String tipo;
	private String nome;
	private String descricao;
	
	// Constructor
	public Ameaca(String tipo, String nome, String descricao) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Ameaca() {};
	
	// Methods
	public void show() {
		System.out.println("\n| INSTÂNCIA DE AMEAÇA");
		System.out.println("Tipo: " + this.getTipo());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Descrição: " + this.getDescricao());
	}
	
	// Getters and Setters
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
