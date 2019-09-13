package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PagoServicioGestorRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5486911567261904419L;

	private String documentoPersonaCliente;
	
	private Integer codigoComprobante;
	
	private String documentoPersonaPago;
	
	private String nombreGestor;
	
	private BigDecimal cantidadPago;
	
	public PagoServicioGestorRequest() {
		
	}

	public Integer getCodigoComprobante() {
		return codigoComprobante;
	}

	public void setCodigoComprobante(Integer codigoComprobante) {
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

	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public String getNombreGestor() {
		return nombreGestor;
	}

	public void setNombreGestor(String nombreGestor) {
		this.nombreGestor = nombreGestor;
	}
}
