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
	
	// Getters and Setters
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getResultado() {
		return resultado;
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
