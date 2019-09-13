package com.dev.crm.core.dto;

import java.io.Serializable;

public class ConsolidadoInternetResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2594727851063645922L;

	private String fechaPago;
	
	private String cajaUno;
	
	private String cajaDos;
	
	private String cajaTres;

	public ConsolidadoInternetResultViewModel() {
		
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getCajaUno() {
		return cajaUno;
	}

	public void setCajaUno(String cajaUno) {
		this.cajaUno = cajaUno;
	}

	public String getCajaDos() {
		return cajaDos;
	}

	public void setCajaDos(String cajaDos) {
		this.cajaDos = cajaDos;
	}

	public String getCajaTres() {
		return cajaTres;
	}

	public void setCajaTres(String cajaTres) {
		this.cajaTres = cajaTres;
	}
}
