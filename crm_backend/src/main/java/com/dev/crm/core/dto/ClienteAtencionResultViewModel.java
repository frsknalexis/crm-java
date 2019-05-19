package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClienteAtencionResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8602600163872266251L;

	private Integer estado;
	
	private String documentoPersonaCliente;
	
	private String clientenombre;
	
	private String herramienta;
	
	private Integer falta;

	public ClienteAtencionResultViewModel() {
		
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(String herramienta) {
		this.herramienta = herramienta;
	}

	public Integer getFalta() {
		return falta;
	}

	public void setFalta(Integer falta) {
		this.falta = falta;
	}

	public String getClientenombre() {
		return clientenombre;
	}

	public void setClientenombre(String clientenombre) {
		this.clientenombre = clientenombre;
	}
	
}
