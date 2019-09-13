package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class CuentasRangoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2430022128736781411L;

	private Date fechaInicio;
	
	private Date fechaFin;

	public CuentasRangoRequest() {
		
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
}
