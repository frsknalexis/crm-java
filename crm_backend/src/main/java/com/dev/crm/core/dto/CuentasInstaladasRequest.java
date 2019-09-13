package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class CuentasInstaladasRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4001729252266048445L;

	private Date fechaInicial;
	
	private Date fechaFinal;

	public CuentasInstaladasRequest() {
		
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
}
