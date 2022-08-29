package com.kai.wang.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.RequestProduto;
import com.kai.wang.mvc.mudi.service.ProdutoService;

@Controller
@RequestMapping(value="/pedido")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value="/formulario")
	public String formularioCadastro(RequestProduto requestProduto)
	{
		return "pedido/formulario";
	}
	
	@PostMapping(value="/novo")
	public String novo(@Valid RequestProduto requestProduto, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "pedido/formulario";
		}
		String nome = requestProduto.getNomeProduto();
		String urlProdut = requestProduto.getUrlProduto();
		String urlImagem = requestProduto.getUrlImage();
		String descricão = requestProduto.getDescricao();
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setUrlProduto(urlProdut);
		produto.setUrlImagem(urlImagem);
		produto.setDescricao(descricão);
		
		produtoService.adicionar(produto);
		return "redirect:/home";
	}
	
}
