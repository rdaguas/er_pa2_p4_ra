package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public void insertar(Materia materia);
	public List<Materia> listaTotal();
	public Materia visualizar(Integer id);
	public Materia buscarPorCodigo(String codigo);
	

}
