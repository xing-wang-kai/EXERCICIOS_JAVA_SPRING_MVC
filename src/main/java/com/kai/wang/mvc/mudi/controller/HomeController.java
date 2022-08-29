package com.kai.wang.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kai.wang.mvc.mudi.model.Produto;
import com.kai.wang.mvc.mudi.service.ProdutoService;

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("home")
	public String home(Model model)
	{
		
		List<Produto> produtos =  produtoService.buscar();
		
		model.addAttribute("produtos", produtos);
		
		return "home";
	}
}
