package com.example.rest.entidades;

public class TipoReclamo {

	private int idtipoReclamo;
	private String descripcion;
	private String estado;
	private String fechaRegistro;
	
	
	public int getIdtipoReclamo() {
		return idtipoReclamo;
	}
	public void setIdtipoReclamo(int idtipoReclamo) {
		this.idtipoReclamo = idtipoReclamo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
