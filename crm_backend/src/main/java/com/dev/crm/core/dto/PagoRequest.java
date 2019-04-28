package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PagoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963154295950006311L;
	
	private BigDecimal codigoComprobante;
	
	private String documentoPersonaPago;
	
	private String documentoPersonaCliente;
	
	private Double cantidadPago;
	
	private String numeroCaja;

	public PagoRequest() {
	
	}
	
	public BigDecimal getCodigoComprobante() {
		return codigoComprobante;
	}

	public void setCodigoComprobante(BigDecimal codigoComprobante) {
		this.codigoComprobante = codigoComprobante;
	}
	
	public String getDocumentoPersonaPago() {
		return documentoPersonaPago;
	}

	public void setDocumentoPersonaPago(String documentoPersonaPago) {
		this.documentoPersonaPago = documentoPersonaPago;
	}
	
	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}
	
	public Double getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(Double cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public String getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}
}
