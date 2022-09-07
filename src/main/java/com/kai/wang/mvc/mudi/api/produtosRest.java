package com.kai.wang.mvc.mudi.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.Status;
import com.kai.wang.mvc.mudi.service.ProdutoService;

@RestController
@RequestMapping("api/produtos")
public class produtosRest {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("todos")
	public List<Produto> bucarTodosProdutos()
	{
		return produtoService.buscar();
	}
	@GetMapping("{id}")
	public Optional<Produto> buscarUm(@PathVariable("id") Long id)
	{
		return produtoService.findById(id);
	}
}
