package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClienteAtencionDetalleResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6061319826634754568L;
	
	private String documentoPersonaCliente;
	
	private String herramienta;
	
	private Integer faltas;

	public ClienteAtencionDetalleResultViewModel() {
		
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

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}
}
