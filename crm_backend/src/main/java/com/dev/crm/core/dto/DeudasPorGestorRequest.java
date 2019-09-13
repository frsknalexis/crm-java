package com.dev.crm.core.dto;

import java.io.Serializable;

public class DeudasPorGestorRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8969207819116332380L;

	private String gestorResponsable;

	public DeudasPorGestorRequest() {
		
	}

	public String getGestorResponsable() {
		return gestorResponsable;
	}

	public void setGestorResponsable(String gestorResponsable) {
		this.gestorResponsable = gestorResponsable;
	}
}
