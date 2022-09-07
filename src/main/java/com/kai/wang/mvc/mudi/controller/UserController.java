package com.kai.wang.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.RequestProduto;
import com.kai.wang.mvc.mudi.model.Status;
import com.kai.wang.mvc.mudi.model.User;
import com.kai.wang.mvc.mudi.service.ProdutoService;
import com.kai.wang.mvc.mudi.service.UserService;

@Controller
@RequestMapping("usuario")
public class UserController {
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private UserService userService;
	
	@GetMapping("produto")
	public String home(Model model)
	{
		
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.buscarUsuario(nome);
		List<Produto> produtos =  produtoService.buscarPorUser(user);
		
		model.addAttribute("produtos", produtos);
		
		return "usuario/home";
	}
	
	@GetMapping("produto/{status}")
	public String status(@PathVariable("status") String status, Model model, Principal principal)
	{
		System.out.println(status);
		User user = userService.buscarUsuario(principal.getName());
		List<Produto> produtos = produtoService.buscarPorStatusEUser(Status.valueOf(status.toUpperCase()), user);
		model.addAttribute("produtos", produtos);
		return "usuario/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError()
	{
		return "redirect:/home";
	}
	
	@GetMapping("pedido/formulario")
	public String formulario(RequestProduto request) {
		return "pedido/formulario";
	}
}
