package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class VentasPorInstalarResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1144555062039854269L;

	private String documentoPersonaCliente;
	
	private String cliente;
	
	private String direccionActualPersona;
	
	private Integer codigoCuenta;
	
	private Integer codigoDetalleCuenta;
	
	private Date fechaProgramadaDetalleCuenta;

	public VentasPorInstalarResultViewModel() {
		
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccionActualPersona() {
		return direccionActualPersona;
	}

	public void setDireccionActualPersona(String direccionActualPersona) {
		this.direccionActualPersona = direccionActualPersona;
	}

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public Integer getCodigoDetalleCuenta() {
		return codigoDetalleCuenta;
	}

	public void setCodigoDetalleCuenta(Integer codigoDetalleCuenta) {
		this.codigoDetalleCuenta = codigoDetalleCuenta;
	}

	public Date getFechaProgramadaDetalleCuenta() {
		return fechaProgramadaDetalleCuenta;
	}

	public void setFechaProgramadaDetalleCuenta(Date fechaProgramadaDetalleCuenta) {
		this.fechaProgramadaDetalleCuenta = fechaProgramadaDetalleCuenta;
	}
}
