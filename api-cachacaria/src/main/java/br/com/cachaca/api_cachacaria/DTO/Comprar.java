package br.com.cachaca.api_cachacaria.DTO;

import java.util.List;

public class Comprar {
	private String nome;
	private String cnpj;
	private List<ProdutoDTO> produto;
	private List<ProdutoDTO> produtos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<ProdutoDTO> getProdutos() {
		return getProdutos();
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

}
