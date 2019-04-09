package com.dev.crm.core.model.entity;

import java.io.Serializable;

public class ClientePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2336749040195209873L;

	private Integer consecutivoCliente;
	
	private String documentoPersonaCliente;

	public ClientePK() {
		
	}

	public ClientePK(Integer consecutivoCliente, String documentoPersonaCliente) {
		super();
		this.consecutivoCliente = consecutivoCliente;
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}
}
