package com.dev.crm.core.dto;

import java.io.Serializable;

public class CodigoConsecutivoClienteRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4302212975921113876L;

	private String documentoPersonaCliente;

	public CodigoConsecutivoClienteRequest() {
		
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}
}
