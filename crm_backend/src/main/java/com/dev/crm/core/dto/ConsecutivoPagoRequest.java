package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ConsecutivoPagoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1499892782453020998L;

	private Integer codigoPago;
	
	private String codigoUsuario;
	
	private BigDecimal cantidadPago;
	
	private Integer codigoComprobante;
	
	public ConsecutivoPagoRequest() {
		
	}

	public Integer getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(Integer codigoPago) {
		this.codigoPago = codigoPago;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public Integer getCodigoComprobante() {
		return codigoComprobante;
	}

	public void setCodigoComprobante(Integer codigoComprobante) {
		this.codigoComprobante = codigoComprobante;
	}
}
