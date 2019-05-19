package com.dev.crm.core.dto;

import java.io.Serializable;

public class PlantaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963154295950006311L;

	private String documentoPersona;

	public PlantaRequest() {
	
	}

	public String getDocumentoPersona() {
		return documentoPersona;
	}

	public void setDocumentoPersona(String documentoPersona) {
		this.documentoPersona = documentoPersona;
	}
	
}
