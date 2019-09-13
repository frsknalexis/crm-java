package com.dev.crm.core.dto;

import java.io.Serializable;

public class CuentasResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5520507581628040807L;
	
	private Integer numeracion;
	
	private Integer codigoDetalleCuenta;
	
	private Integer codigoCuenta;
	
	private String cliente;
	
	private String observacion;
	
	private String documentoPersona;

	public CuentasResultViewModel() {
		
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

	public String getDocumentoPersona() {
		return documentoPersona;
	}

	public void setDocumentoPersona(String documentoPersona) {
		this.documentoPersona = documentoPersona;
	}
}
