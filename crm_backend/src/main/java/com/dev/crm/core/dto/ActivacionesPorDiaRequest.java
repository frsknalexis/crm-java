package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class ActivacionesPorDiaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4710191666989141388L;

	private Date fechaBusqueda;

	public ActivacionesPorDiaRequest() {
		
	}

	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}
}
