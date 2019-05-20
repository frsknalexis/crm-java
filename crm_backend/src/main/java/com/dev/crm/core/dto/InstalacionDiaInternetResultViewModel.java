package com.dev.crm.core.dto;

import java.io.Serializable;

public class InstalacionDiaInternetResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1619609110996333790L;

	private Integer codigoDetalleCuenta;
	
	private String cliente;
	
	private String direccionActualCliente;
	
	private String referenciaDireccion;
	
	private String telefonoCliente;
	
	private String documentoPersonaCliente;

	public InstalacionDiaInternetResultViewModel() {
	
	}

	public Integer getCodigoDetalleCuenta() {
		return codigoDetalleCuenta;
	}

	public void setCodigoDetalleCuenta(Integer codigoDetalleCuenta) {
		this.codigoDetalleCuenta = codigoDetalleCuenta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccionActualCliente() {
		return direccionActualCliente;
	}

	public void setDireccionActualCliente(String direccionActualCliente) {
		this.direccionActualCliente = direccionActualCliente;
	}

	public String getReferenciaDireccion() {
		return referenciaDireccion;
	}

	public void setReferenciaDireccion(String referenciaDireccion) {
		this.referenciaDireccion = referenciaDireccion;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}
}
