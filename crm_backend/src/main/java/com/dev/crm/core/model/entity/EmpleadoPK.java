package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class EmpleadoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2062011058915275185L;

	private Integer codigoEmpleado;
	
	private String documentoPersonaEmpleado;
	
	public EmpleadoPK() {
		
	}

	public EmpleadoPK(String documentoPersonaEmpleado, Integer codigoEmpleado) {
		super();
		this.documentoPersonaEmpleado = documentoPersonaEmpleado;
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getDocumentoPersonaEmpleado() {
		return documentoPersonaEmpleado;
	}

	public void setDocumentoPersonaEmpleado(String documentoPersonaEmpleado) {
		this.documentoPersonaEmpleado = documentoPersonaEmpleado;
	}

	public Integer getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void Integer(Integer codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
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
		final EmpleadoPK other = (EmpleadoPK) obj;
		if(!Objects.equals(this.documentoPersonaEmpleado, other.documentoPersonaEmpleado)) {
			return false;
		}
		if(!Objects.equals(this.codigoEmpleado, other.codigoEmpleado)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.documentoPersonaEmpleado);
		hash = 59 * hash + Objects.hashCode(this.codigoEmpleado);
		return hash;
	}
}
