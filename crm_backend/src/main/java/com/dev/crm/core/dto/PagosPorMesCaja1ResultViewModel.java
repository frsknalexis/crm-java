package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dev.crm.core.json.JsonBigDecimalSimpleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PagosPorMesCaja1ResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4325105592399971099L;

	private String diaFechaPago;
	
	@JsonSerialize(using = JsonBigDecimalSimpleSerializer.class)
	private BigDecimal cantidadPago;

	public PagosPorMesCaja1ResultViewModel() {
		
	}

	public String getDiaFechaPago() {
		return diaFechaPago;
	}

	public void setDiaFechaPago(String diaFechaPago) {
		this.diaFechaPago = diaFechaPago;
	}

	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}
}
