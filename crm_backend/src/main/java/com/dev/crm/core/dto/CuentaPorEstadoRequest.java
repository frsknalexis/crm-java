package com.dev.crm.core.dto;

import java.io.Serializable;

public class CuentaPorEstadoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8791196510838902704L;

	private Integer codigoEstado;

	public CuentaPorEstadoRequest() {
	
	}

	public Integer getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(Integer codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
}
