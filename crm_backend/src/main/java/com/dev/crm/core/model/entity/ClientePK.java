package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		final ClientePK other = (ClientePK) obj;
		if(!Objects.equals(this.consecutivoCliente, other.consecutivoCliente)) {
			return false;
		}
		if(!Objects.equals(this.documentoPersonaCliente, other.documentoPersonaCliente)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.consecutivoCliente);
        hash = 59 * hash + Objects.hashCode(this.documentoPersonaCliente);
        return hash;
	}
}
