package com.kai.wang.mvc.mudi.model;

import javax.validation.constraints.NotBlank;

public class RequestProduto {
	@NotBlank(message ="ATENÇÃO: 'Nome' não pode ser Nulo! ")
	private String nomeProduto;
	@NotBlank(message ="ATENÇÃO: 'Url do Produto' não pode ser Nulo! ")
	private String urlProduto;
	@NotBlank(message ="ATENÇÃO: 'Url da Imagem' não pode ser Nulo! ")
	private String urlImage;
	private String descricao;
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString()
	{
		return "[ nome: " + this.getNomeProduto()
				+ ", descricao: " + this.getDescricao() 
				+ ", url Produto: " + this.getUrlProduto()
				+ ", url Imagem: " + this.getUrlImage();
	}
	public Produto toProduto() {
		Produto produto = new Produto();
		produto.setNome(this.getNomeProduto());
		produto.setUrlProduto(this.getUrlProduto());
		produto.setUrlImagem(this.getUrlImage());
		produto.setDescricao(this.getDescricao());
		produto.setStatus(Status.AGUARDANDO);
		return produto;
	}
	
}
