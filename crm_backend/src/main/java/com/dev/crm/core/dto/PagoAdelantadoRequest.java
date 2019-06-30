package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PagoAdelantadoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5923154832824983479L;

	private String documentoPersonaCliente;
	
	private BigDecimal codigoComprobante;
	
	private String documentoPersonaPago;
	
	private String usuario;
	
	private BigDecimal montoPago;
	
	public PagoAdelantadoRequest() {
		
	}
	
	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(BigDecimal montoPago) {
		this.montoPago = montoPago;
	}
}
