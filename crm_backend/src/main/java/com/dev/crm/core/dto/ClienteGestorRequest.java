package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClienteGestorRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3159252023934265426L;

	private String documentoPersonaCliente;
	
	private String gestorResponsable;

	public ClienteGestorRequest() {
		
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getGestorResponsable() {
		return gestorResponsable;
	}

	public void setGestorResponsable(String gestorResponsable) {
		this.gestorResponsable = gestorResponsable;
	}
}
