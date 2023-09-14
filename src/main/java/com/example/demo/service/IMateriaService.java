package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {
	
	public void crear(Materia materia);
	public List<Materia> listaTotal();
	public Materia visualizar(Integer id);
	public Materia buscarPorCodigo(String codigo);
	
	


}
