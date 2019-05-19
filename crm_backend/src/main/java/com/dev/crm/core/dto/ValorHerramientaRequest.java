package com.dev.crm.core.dto;

import java.io.Serializable;

public class ValorHerramientaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;
	
	private String descripcionherramienta;

	public ValorHerramientaRequest() {
		
	}
	
	public String getDescripcionherramienta() {
		return descripcionherramienta;
	}
	public void setDescripcionherramienta(String descripcionherramienta) {
		this.descripcionherramienta = descripcionherramienta;
	}
	
}
