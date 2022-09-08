package com.kai.wang.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kai.wang.mvc.mudi.model.Oferta;
import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.RequisicaoOferta;
import com.kai.wang.mvc.mudi.service.ProdutoService;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoOferta req)
	{
		Optional<Produto> produtos = produtoService.findById(req.getPedidoId());
		
		if(!produtos.isPresent()) {
			System.out.println("Não registrou Pedidos");
			return null;
		}
		System.out.println("produto: " + req);
		
		try {
						
			Produto produto = produtos.get();
			Oferta oferta = req.toOferta();
			oferta.setProdutos(produto);
			System.out.println("produto: " + produtos);
			System.out.println("produto: " + oferta);
			
			produto.getOfertas().add(oferta);
			
			produtoService.adicionar(produto);
			
			return oferta;
		
		}catch(Exception err) {
			System.out.println("Message: " + err.getMessage());
			System.out.println("Localized: " + err.getLocalizedMessage());
			System.out.println("Cause: " + err.getCause());
			System.out.println("Class: " + err.getClass());
			System.out.println("StackTrace: " + err.getStackTrace());
			System.out.println("Suppressed: " + err.getSuppressed());
			System.out.println("Ocorreu um error");
			return null;
		}
		
	}

}
