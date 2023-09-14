package com.example.demo.repository.modelo.dto;

public class MatriculaDTO {

	private String cedula;
	private String apellido;
	private String nombre;
	private String codigo;
	private String fechaDeMatricula;
	
	
	public MatriculaDTO() {
		
	}


	public MatriculaDTO(String cedula, String apellido, String nombre, String codigo, String fechaDeMatricula) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombre;
		this.codigo = codigo;
		this.fechaDeMatricula = fechaDeMatricula;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getFechaDeMatricula() {
		return fechaDeMatricula;
	}


	public void setFechaDeMatricula(String fechaDeMatricula) {
		this.fechaDeMatricula = fechaDeMatricula;
	}
	
	
	
	
}
