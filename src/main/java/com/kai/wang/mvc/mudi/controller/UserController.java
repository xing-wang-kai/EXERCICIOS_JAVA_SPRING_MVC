package com.kai.wang.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.model.Status;
import com.kai.wang.mvc.mudi.service.ProdutoService;

@Controller
@RequestMapping("usuario")
public class UserController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("produto")
	public String home(Model model, Principal principal)
	{
		
		List<Produto> produtos =  produtoService.buscarPorUser(principal.getName());
		
		model.addAttribute("produtos", produtos);
		
		return "usuario/home";
	}
	
	@GetMapping("produto/{status}")
	public String status(@PathVariable("status") String status, Model model, Principal principal)
	{
		System.out.println(status);
		List<Produto> produtos = produtoService.findByStatusAndUser(Status.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("produtos", produtos);
		return "usuario/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError()
	{
		return "redirect:/home";
	}
}
