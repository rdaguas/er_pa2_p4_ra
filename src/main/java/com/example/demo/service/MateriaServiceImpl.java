package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crear(Materia materia) {
		this.materiaRepository.insertar(materia);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<Materia> listaTotal() {
		// TODO Auto-generated method stub
		return this.materiaRepository.listaTotal();
	}

	@Override
	public Materia visualizar(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.visualizar(id);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.buscarPorCodigo(codigo);
	}

}
