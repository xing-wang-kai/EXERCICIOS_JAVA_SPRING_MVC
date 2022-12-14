package com.kai.wang.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.RequestProduto;
import com.kai.wang.mvc.mudi.model.User;
import com.kai.wang.mvc.mudi.service.ProdutoService;
import com.kai.wang.mvc.mudi.service.UserService;

@Controller
@RequestMapping("pedido")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private UserService userService;
	
	@GetMapping("formulario")
	public String formularioCadastro(RequestProduto requestProduto)
	{
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequestProduto requestProduto, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "pedido/formulario";
		}
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.buscarUsuario(userName);
		
		
		Produto produto = requestProduto.toProduto();
		produto.setUser(user);
		
		produtoService.adicionar(produto);
		
		return "redirect:/home";
	}
	
}
