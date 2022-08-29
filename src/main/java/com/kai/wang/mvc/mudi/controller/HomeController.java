package com.kai.wang.mvc.mudi.controller;

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
@RequestMapping(value="home")
public class HomeController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public String home(Model model)
	{
		
		List<Produto> produtos =  produtoService.buscar();
		
		model.addAttribute("produtos", produtos);
		
		return "home";
	}
	
	@GetMapping(value="/{status}")
	public String status(@PathVariable("status") String status, Model model)
	{
		List<Produto> produtos = produtoService.findByStatus(Status.valueOf(status.toUpperCase()));
		model.addAttribute("produtos", produtos);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError()
	{
		return "redirect:/home";
	}
}
