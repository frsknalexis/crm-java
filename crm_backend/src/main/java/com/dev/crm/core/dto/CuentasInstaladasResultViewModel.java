package com.dev.crm.core.dto;

import java.io.Serializable;

public class CuentasInstaladasResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5486723274347204215L;

	private Integer numeracion;
	
	private Integer codigoDetalleCuenta;
	
	private Integer codigoCuenta;
	
	private String cliente;
	
	private String observacion;
	
	private String documentoCliente;

	public CuentasInstaladasResultViewModel() {
	
	}

	public Integer getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(Integer numeracion) {
		this.numeracion = numeracion;
	}

	public Integer getCodigoDetalleCuenta() {
		return codigoDetalleCuenta;
	}

	public void setCodigoDetalleCuenta(Integer codigoDetalleCuenta) {
		this.codigoDetalleCuenta = codigoDetalleCuenta;
	}

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}
}
