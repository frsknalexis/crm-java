package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

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
	
	private Integer codigoCuenta;
	
	private Date fechaInstalacion;

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

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}

	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}
}
