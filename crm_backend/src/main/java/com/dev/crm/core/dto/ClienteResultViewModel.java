package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClienteResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;

	private String cliente;
	
	private String documentoPersona;
	
	private String direccionPersona;
	
	private String referenciaPersona;
	
	private Integer anio;

	public ClienteResultViewModel() {
		
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDocumentoPersona() {
		return documentoPersona;
	}

	public void setDocumentoPersona(String documentoPersona) {
		this.documentoPersona = documentoPersona;
	}

	public String getDireccionPersona() {
		return direccionPersona;
	}

	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}

	public String getReferenciaPersona() {
		return referenciaPersona;
	}

	public void setReferenciaPersona(String referenciaPersona) {
		this.referenciaPersona = referenciaPersona;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
}
