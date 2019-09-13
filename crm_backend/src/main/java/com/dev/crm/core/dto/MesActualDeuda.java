package com.dev.crm.core.dto;

import java.io.Serializable;

public class MesActualDeuda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -192569864502908955L;

	private String mesactualdeudanombre;
	
	private String valordedeudaactual;

	public MesActualDeuda() {
		
	}

	public String getMesactualdeudanombre() {
		return mesactualdeudanombre;
	}

	public void setMesactualdeudanombre(String mesactualdeudanombre) {
		this.mesactualdeudanombre = mesactualdeudanombre;
	}

	public String getValordedeudaactual() {
		return valordedeudaactual;
	}

	public void setValordedeudaactual(String valordedeudaactual) {
		this.valordedeudaactual = valordedeudaactual;
	}
}
