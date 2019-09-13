package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class CuentaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 93435974003845063L;

	private Date fechaBusqueda;

	public CuentaRequest() {
		
	}

	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}
}
