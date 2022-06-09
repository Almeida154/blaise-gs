package br.com.blaise;

public class Fornecedor extends Empresa {
	// Attributes
	private int marcasAdquiridasQntd;

	// Constructor
	public Fornecedor(String cnpj, String nome, String seguimento, int marcasAdquiridasQntd) {
		super(cnpj, nome, seguimento);
		this.marcasAdquiridasQntd = marcasAdquiridasQntd;
	}
	
	public Fornecedor() {};
	
	// Methods
	public void show() {
		System.out.println("\n| INSTÂNCIA DE FORNECEDOR");
		System.out.println("CNPJ: " + this.getCnpj());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Seguimento: " + this.getSeguimento());
		System.out.println("Quantidade de marcas que distribui: " + this.getMarcasAdquiridasQntd());
	}
	
	// Getters and Setters
	public int getMarcasAdquiridasQntd() {
		return marcasAdquiridasQntd;
	}

	public void setMarcasAdquiridasQntd(int marcasAdquiridasQntd) {
		this.marcasAdquiridasQntd = marcasAdquiridasQntd;
	}
}
