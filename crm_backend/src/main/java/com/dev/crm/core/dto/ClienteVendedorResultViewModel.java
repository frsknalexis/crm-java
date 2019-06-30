package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClienteVendedorResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2242841541725559829L;
	
	private String documentoPersonaCliente;
	
	private String nombreComercialCliente;
	
	private String cliente;
	
	private String direccionActualCliente;
	
	private String referenciaDireccionCliente;
	
	private String facebookCliente;
	
	private String correoCliente;
	
	private Boolean estadoCliente;

	public ClienteVendedorResultViewModel() {
				
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

	public String getReferenciaDireccionCliente() {
		return referenciaDireccionCliente;
	}

	public void setReferenciaDireccionCliente(String referenciaDireccionCliente) {
		this.referenciaDireccionCliente = referenciaDireccionCliente;
	}

	public String getFacebookCliente() {
		return facebookCliente;
	}

	public void setFacebookCliente(String facebookCliente) {
		this.facebookCliente = facebookCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public Boolean getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(Boolean estadoCliente) {
		this.estadoCliente = estadoCliente;
	}	
}
