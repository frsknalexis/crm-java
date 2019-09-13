package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class ActivacionesPorRangoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3662773021753674049L;

	private Date fechaInicial;
	
	private Date fechaFinal;

	public ActivacionesPorRangoRequest() {
		
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
