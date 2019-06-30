package com.dev.crm.core.dto;

import java.io.Serializable;

public class DescuentoPagoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -192569864502908955L;
	
	private String mesvalidopago;
	
	private String montoapagar;

	public DescuentoPagoResultViewModel() {
		
	}

	public String getMesvalidopago() {
		return mesvalidopago;
	}

	public void setMesvalidopago(String mesvalidopago) {
		this.mesvalidopago = mesvalidopago;
	}

	public String getMontoapagar() {
		return montoapagar;
	}

	public void setMontoapagar(String montoapagar) {
		this.montoapagar = montoapagar;
	}
}
