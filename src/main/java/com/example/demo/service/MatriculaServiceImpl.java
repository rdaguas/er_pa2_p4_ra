package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crear(Matricula matricula) {
		
		Estudiante estudiante = this.estudianteRepository.buscarPorCedula(matricula.getEstudiante().getCedula());
		Materia materia = this.materiaRepository.buscarPorCodigo(matricula.getMateria().getCodigo());
		
		Matricula matri = new Matricula();
		matri.setEstudiante(estudiante);
		matri.setMateria(materia);
		
		this.matriculaRepository.insertar(matri);
		
		Integer numNuevo = materia.getNumeroDeEstudiantes()+1;
		materia.setNumeroDeEstudiantes(numNuevo);

		
		this.materiaRepository.insertar(materia);
		
	}

	@Override
	public List<MatriculaDTO> listaMatricula() {
		// TODO Auto-generated method stub
		return this.matriculaRepository.listaMatricula();
	}

}
