package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class PagosPorDiaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6703244048134673884L;

	private Date fechaBusqueda;
	
	private String codigoUsuario;

	public PagosPorDiaRequest() {
		
	}

	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
}
