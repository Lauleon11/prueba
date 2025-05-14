package com.unab.equipos.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexEquipo {
	@GetMapping({"/","/index","/menu"})
	public String redirectToHomePage() {
		return "index";
}

}
