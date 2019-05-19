package com.dev.crm.core.dto;

import java.io.Serializable;

public class HerramientaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;

	private String herramienta;
	
	private String descripcionherramienta;
	
	private String fechainicio;
	
	private String valor;
	
	private String descripciontipoherramienta;
	
	private String fechafinal;
	
	public String getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(String herramienta) {
		this.herramienta = herramienta;
	}

	public String getDescripciontipoherramienta() {
		return descripciontipoherramienta;
	}

	public void setDescripciontipoherramienta(String descripciontipoherramienta) {
		this.descripciontipoherramienta = descripciontipoherramienta;
	}

	public String getDescripcionherramienta() {
		return descripcionherramienta;
	}

	public void setDescripcionherramienta(String descripcionherramienta) {
		this.descripcionherramienta = descripcionherramienta;
	}
	
	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechafinal() {
		return fechafinal;
	}

	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}

	public HerramientaResultViewModel() {
		
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
