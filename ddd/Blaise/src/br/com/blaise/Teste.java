package br.com.blaise;

public class Teste {
	// Attributes
	private String data;
	private String resultado;
	private String produto;
	private String ameaca;
	
	// Constructor
	public Teste(String data, String resultado, String produto, String ameaca) {
		super();
		this.data = data;
		this.resultado = resultado;
		this.produto = produto;
		this.ameaca = ameaca;
	}
	
	public Teste() {};
	
	// Methods
	public void agendar(String data) {
		if (this.data == null) {
			this.data = data;
		} else {
			System.out.println("Teste já agendado");
		}
	}

	public void show() {
		System.out.println("\n| INSTÂNCIA DE TESTE");
		System.out.println("Data: " + this.getData());
		System.out.println("Resultado: " + this.getResultado());
		System.out.println("Produto testado: " + this.getProduto());
		System.out.println("Ameaça testada: " + this.getAmeaca());
	}
	
	// Getters and Setters
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getResultado() {
		if (resultado != null && !resultado.equals("")) {
			return resultado;
		} else {
			return "Nenhum resultado encontrado";
		}
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getAmeaca() {
		return ameaca;
	}
	public void setAmeaca(String ameaca) {
		this.ameaca = ameaca;
	}
}
