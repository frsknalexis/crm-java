package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class CuentaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2688483272336421701L;

	private String documentoPersonaCliente;
	
	private String codigoCuenta;
	
	private String codigoAnio;
	
	private Integer consecutivoCliente;

	public CuentaPK() {
	
	}
	
	public CuentaPK(String documentoPersonaCliente, String codigoCuenta, String codigoAnio,
			Integer consecutivoCliente) {
		super();
		this.documentoPersonaCliente = documentoPersonaCliente;
		this.codigoCuenta = codigoCuenta;
		this.codigoAnio = codigoAnio;
		this.consecutivoCliente = consecutivoCliente;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getCodigoAnio() {
		return codigoAnio;
	}

	public void setCodigoAnio(String codigoAnio) {
		this.codigoAnio = codigoAnio;
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
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
		final CuentaPK other = (CuentaPK) obj;
		if(!Objects.equals(this.documentoPersonaCliente, other.documentoPersonaCliente)) {
			return false;
		}
		if(!Objects.equals(this.codigoCuenta, other.codigoCuenta)) {
			return false;
		}
		if(!Objects.equals(this.codigoAnio, other.codigoAnio)) {
			return false;
		}
		if(!Objects.equals(this.consecutivoCliente, other.consecutivoCliente)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.documentoPersonaCliente);
		hash = 59 * hash + Objects.hashCode(this.codigoCuenta);
		hash = 59 * hash + Objects.hashCode(this.codigoAnio);
		hash = 59 * hash + Objects.hashCode(this.consecutivoCliente);
		return hash;
	}
}
