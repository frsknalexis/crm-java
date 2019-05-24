package com.dev.crm.core.dto;

import java.io.Serializable;

public class ModuloResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;
	
	private String numeracionmodulo;
	
	private String descripcionmodulo;

	public ModuloResultViewModel() {
		
	}

	public String getNumeracionmodulo() {
		return numeracionmodulo;
	}

	public void setNumeracionmodulo(String numeracionmodulo) {
		this.numeracionmodulo = numeracionmodulo;
	}

	public String getDescripcionmodulo() {
		return descripcionmodulo;
	}

	public void setDescripcionmodulo(String descripcionmodulo) {
		this.descripcionmodulo = descripcionmodulo;
	}
	
}
