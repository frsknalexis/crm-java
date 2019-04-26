package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClientePagoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -192569864502908955L;

	
	private String documentoPersonaCliente;
	
	private String nombreComercialCliente;
	
	private String cliente;
	
	private String direccionActualCliente;
	
	private String referencia;

	public ClientePagoResultViewModel() {
		
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getNombreComercialCliente() {
		return nombreComercialCliente;
	}

	public void setNombreComercialCliente(String nombreComercialCliente) {
		this.nombreComercialCliente = nombreComercialCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccionActualCliente() {
		return direccionActualCliente;
	}

	public void setDireccionActualCliente(String direccionActualCliente) {
		this.direccionActualCliente = direccionActualCliente;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
}
