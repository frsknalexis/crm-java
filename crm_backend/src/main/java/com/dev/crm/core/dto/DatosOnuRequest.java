package com.dev.crm.core.dto;

import java.io.Serializable;

public class DatosOnuRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4744387154902566090L;
	
	private String snDescripcion;
	
	private String macDescripcion;

	public DatosOnuRequest() {
		
	}

	public String getSnDescripcion() {
		return snDescripcion;
	}

	public void setSnDescripcion(String snDescripcion) {
		this.snDescripcion = snDescripcion;
	}

	public String getMacDescripcion() {
		return macDescripcion;
	}

	public void setMacDescripcion(String macDescripcion) {
		this.macDescripcion = macDescripcion;
	}
}
