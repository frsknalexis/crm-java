package com.dev.crm.core.dto;

import java.io.Serializable;

public class EditarHerramientaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;

	private Integer codigoherramienta;
	
	private String descripcionherramienta;
	
	private String fechainicio;
	
	private String fechafinal;
	
	private Integer secuencialherramienta;
	
	public EditarHerramientaRequest() {
		
	}

	public Integer getCodigoherramienta() {
		return codigoherramienta;
	}

	public void setCodigoherramienta(Integer codigoherramienta) {
		this.codigoherramienta = codigoherramienta;
	}

	public String getDescripcionherramienta() {
		return descripcionherramienta;
	}

	public void setDescripcionherramienta(String descripcionherramienta) {
		this.descripcionherramienta = descripcionherramienta;
	}

	public Integer getSecuencialherramienta() {
		return secuencialherramienta;
	}

	public void setSecuencialherramienta(Integer secuencialherramienta) {
		this.secuencialherramienta = secuencialherramienta;
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
	
}
