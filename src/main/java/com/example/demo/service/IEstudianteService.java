package com.example.demo.service;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	public void crear(Estudiante estudiante);
	public Estudiante buscarPorCedula(String cedula);

}
