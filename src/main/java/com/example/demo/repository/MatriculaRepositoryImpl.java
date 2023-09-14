package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
		
	}

	@Override
	public List<MatriculaDTO> listaMatricula() {
		TypedQuery<MatriculaDTO> myQuery = this.entityManager.createQuery("SELECT new com.example.demo.repository.modelo.dto.MatriculaDTO(m.estudiante.cedula, m.estudiante.apellido, m.materia.nombre, m.materia.codigo)FROM Matricula m", MatriculaDTO.class);
		return myQuery.getResultList();
	}

}
