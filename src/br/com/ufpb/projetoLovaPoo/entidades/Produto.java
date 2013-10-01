package br.com.ufpb.projetoLovaPoo.entidades;

public class Produto {

	private String nome;
	private String marca;
	private String tamanho;
	private String codigoBarras;
	private double precoDeVenda;
	private double precoDeCusto;
	private int quantProdutos;
	private boolean disponivelParaVendas;

	public Produto() {
	}

	public Produto(String nome, String marca, String tamanho,
			String codigoBarras, double precoDeVenda, double precoDeCusto,
			int quantProdutos, boolean disponivelParaVendas) {
		this.nome = nome;
		this.marca = marca;
		this.tamanho = tamanho;
		this.codigoBarras = codigoBarras;
		this.precoDeVenda = precoDeVenda;
		this.precoDeCusto = precoDeCusto;
		this.quantProdutos = quantProdutos;
		this.disponivelParaVendas = disponivelParaVendas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public double getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(double preco) {
		this.precoDeVenda = preco;
	}

	public double getPrecoDeCusto() {
		return precoDeCusto;
	}

	public void setPrecoDeCusto(double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}

	public int getQuantProdutos() {
		return quantProdutos;
	}

	public void setQuantProdutos(int quantProdutos) {
		this.quantProdutos = quantProdutos;
	}

	public boolean isDisponivelParaVendas() {
		return disponivelParaVendas;
	}

	public void setDisponivelParaVendas(boolean disponivelParaVendas) {
		this.disponivelParaVendas = disponivelParaVendas;
	}

}
