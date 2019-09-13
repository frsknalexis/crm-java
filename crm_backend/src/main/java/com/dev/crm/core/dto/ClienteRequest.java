package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClienteRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1703296706344389358L;

	private String documentoPersonaCliente;
	
	private String nombreComercialCliente;
	
	private Boolean estado;
	
	private String correoCliente;
	
	private String facebookCliente;
	
	private Integer codigoSexo;

	public ClienteRequest() {
		
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getFacebookCliente() {
		return facebookCliente;
	}

	public void setFacebookCliente(String facebookCliente) {
		this.facebookCliente = facebookCliente;
	}

	public Integer getCodigoSexo() {
		return codigoSexo;
	}

	public void setCodigoSexo(Integer codigoSexo) {
		this.codigoSexo = codigoSexo;
	}
}
