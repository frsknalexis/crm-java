package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class PagosPorRangoFechaBusquedaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3120367289522683502L;

	private Date fechaInicial;
	
	private Date fechaFinal;
	
	private String codigoUsuario;

	public PagosPorRangoFechaBusquedaRequest() {
		
		
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
}
