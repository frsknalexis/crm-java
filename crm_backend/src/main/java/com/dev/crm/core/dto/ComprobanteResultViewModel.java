package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ComprobanteResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7023553095112589753L;

	private BigDecimal codigoComprobante;
	
	private String descripcionComprobante;

	public ComprobanteResultViewModel() {
		
	}

	public BigDecimal getCodigoComprobante() {
		return codigoComprobante;
	}

	public void setCodigoComprobante(BigDecimal codigoComprobante) {
		this.codigoComprobante = codigoComprobante;
	}

	public String getDescripcionComprobante() {
		return descripcionComprobante;
	}

	public void setDescripcionComprobante(String descripcionComprobante) {
		this.descripcionComprobante = descripcionComprobante;
	}
}
