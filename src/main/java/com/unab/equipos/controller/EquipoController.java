package com.unab.equipos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.unab.equipos.model.Equipo;
import com.unab.equipos.repository.EquipoRepository;


@Controller

public class EquipoController {
	
	@Autowired
	private  EquipoRepository equiporepository;
	
	@GetMapping({"/show","/mostrarequipo","/verequipo"})
	public String listarEquipo(Model model) {
		List<Equipo> listaEquipo = equiporepository.findAll();
		model.addAttribute("listaEquipo", listaEquipo);
		return "show";
	}
	
	@GetMapping("/verequipo/form")
	public String mostrarFormulario (Model model) {
		model.addAttribute("equipo", new Equipo());
		List<Equipo> listaEquipo = equiporepository.findAll();
		model.addAttribute("listaEquipo", listaEquipo);

		return "form";
	}
	
	@PostMapping("/guardarequipo")
	public String guardarEquipo (Equipo equipo) {
		equiporepository.save(equipo);
		return "redirect:/show";
	}
	
	@GetMapping("/equipo/editar/{id}")
	public String modificarEquipo (@PathVariable("id") Long id, Model model) {
		Equipo equipo = equiporepository.findById(id).get();
		model.addAttribute("equipo",equipo);
		List<Equipo> listaEquipo = equiporepository.findAll();
		model.addAttribute("listaEquipo", listaEquipo);

		return "form";
		
	}
	
	@GetMapping("/equipo/eliminar/{id}")
	public String eliminarequipo(@PathVariable("id") Long id, Model model) {
		equiporepository.deleteById(id);
		return "redirect:/show";
	}
	

}
