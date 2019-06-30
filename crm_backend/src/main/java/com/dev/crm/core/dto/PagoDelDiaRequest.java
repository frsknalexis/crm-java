package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class PagoDelDiaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8424141521183412840L;
	
	private String codigoUsuario;
	
	private Date fechaBusqueda;

	public PagoDelDiaRequest() {
		
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}

	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}
}
