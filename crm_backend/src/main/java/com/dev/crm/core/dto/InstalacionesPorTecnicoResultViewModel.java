package com.dev.crm.core.dto;

import java.io.Serializable;

public class InstalacionesPorTecnicoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2091645069498895722L;

	private Integer codigoServicioInternet;
	
	private String documentoPersona;
	
	private String cliente;
	
	private String tecnico;

	public InstalacionesPorTecnicoResultViewModel() {
		
	}

	public Integer getCodigoServicioInternet() {
		return codigoServicioInternet;
	}

	public void setCodigoServicioInternet(Integer codigoServicioInternet) {
		this.codigoServicioInternet = codigoServicioInternet;
	}

	public String getDocumentoPersona() {
		return documentoPersona;
	}

	public void setDocumentoPersona(String documentoPersona) {
		this.documentoPersona = documentoPersona;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
}
