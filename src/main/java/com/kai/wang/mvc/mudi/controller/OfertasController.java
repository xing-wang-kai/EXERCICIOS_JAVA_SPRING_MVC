package com.kai.wang.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("oferta")
public class OfertasController {
	@GetMapping("formulario")
	public String formularioOfertas()
	{
		return "/oferta/home";
	}
}
