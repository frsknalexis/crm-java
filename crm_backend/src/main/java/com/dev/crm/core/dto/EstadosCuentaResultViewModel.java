package com.dev.crm.core.dto;

import java.io.Serializable;

public class EstadosCuentaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6364087068352335959L;

	private Integer codigoEstado;
	
	private String estado;

	public EstadosCuentaResultViewModel() {
		
	}

	public Integer getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(Integer codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
