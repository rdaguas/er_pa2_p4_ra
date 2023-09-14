package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService matriculaService;
	
	@GetMapping("/vistaMatricula")
	public String vistaMatricula(Matricula matricula) {
		return "vistaInsertarMatricula";
	}
	
	@PostMapping("/insertar")
	public String insertarMarticula(Matricula matricula) {
		this.matriculaService.crear(matricula);
		return "redirect:/matriculas/listaMatricula";
	}

	
	@GetMapping("/listaMatricula")
	public String listaMatricula(Model model) {
		List<MatriculaDTO> dto = this.matriculaService.listaMatricula();
		model.addAttribute("dto", dto);
		return"vistaListaMatricula";
	}
}
