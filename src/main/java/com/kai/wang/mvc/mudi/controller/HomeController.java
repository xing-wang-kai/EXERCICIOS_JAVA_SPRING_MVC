package com.kai.wang.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		Page<Produto> produtos =  produtoService.buscarPorStatus(Status.ENTREGUES);
		
		model.addAttribute("produtos", produtos);
		
		return "home";
	}
	
}
