package com.dev.crm.core.dto;

import java.io.Serializable;

public class DatosInternetServicioRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4469501846993872561L;

	private Integer codigoCuenta;
	
	private String documentoPersonaCliente;
	
	private String observacion;

	public DatosInternetServicioRequest() {
	
	}

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
