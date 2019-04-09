package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -334167064515268642L;
	
	private Integer consecutivoCliente;
	
	private String documentoPersonaCliente;
	
	private String codigoCliente;
	
	private String nombreComercialCliente;
	
	private Boolean estado;
	
	private String correoCliente;
	
	private String facebookCliente;
	
	private SexoDTO sexo;

	public ClienteDTO() {
		
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

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
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

	public SexoDTO getSexo() {
		return sexo;
	}

	public void setSexo(SexoDTO sexo) {
		this.sexo = sexo;
	}
}
