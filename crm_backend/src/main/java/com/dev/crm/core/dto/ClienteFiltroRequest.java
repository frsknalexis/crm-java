package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClienteFiltroRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4248264959680703381L;
	
	private String documentoPersona;
	
	private String creadoPor;

	public ClienteFiltroRequest() {
		
	}

	public String getDocumentoPersona() {
		return documentoPersona;
	}

	public void setDocumentoPersona(String documentoPersona) {
		this.documentoPersona = documentoPersona;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}
	
}
