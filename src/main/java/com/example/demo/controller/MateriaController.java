package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping("/vistaMateria")
	public String vistaMateria(Materia materia) {
		return "vistaInsertarMateria";
	}
	
	@PostMapping("/insertar")
	public String insertarMateria(Materia materia) {
		materia.setNumeroDeEstudiantes(0);
		this.materiaService.crear(materia);
		return "redirect:/materias/listaTotal";
	}
	
	@GetMapping("/listaTotal")
	public String listaTotal(Model model) {
		List<Materia> materias = this.materiaService.listaTotal();
		model.addAttribute("materias", materias);
		return "vistaListadoMateria";
	}
	
	@GetMapping("/buscar/{id}")
	public String buscarPorId(@PathVariable("id") Integer id, Model model) {
		Materia mat = this.materiaService.visualizar(id);
		model.addAttribute("materia", mat);
		return "vistaVisualizar";
	}
}
