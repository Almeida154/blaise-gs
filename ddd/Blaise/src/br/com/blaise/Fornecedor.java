package br.com.blaise;

public class Fornecedor extends Empresa {
	// Attributes
	private String marcasAdquiridasQntd;

	// Constructor
	public Fornecedor(String cnpj, String nome, String seguimento, String marcasAdquiridasQntd) {
		super(cnpj, nome, seguimento);
		this.marcasAdquiridasQntd = marcasAdquiridasQntd;
	}
	
	// Getters and Setters
	public String getMarcasAdquiridasQntd() {
		return marcasAdquiridasQntd;
	}

	public void setMarcasAdquiridasQntd(String marcasAdquiridasQntd) {
		this.marcasAdquiridasQntd = marcasAdquiridasQntd;
	}
}
