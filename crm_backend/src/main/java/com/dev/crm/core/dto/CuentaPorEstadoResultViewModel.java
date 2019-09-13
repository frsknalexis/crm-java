package com.dev.crm.core.dto;

import java.io.Serializable;

public class CuentaPorEstadoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1086016269356764094L;

	private Integer numeracion;
	
	private Integer codigoDetalleCuenta;
	
	private String documentoPersonaCliente;
	
	private String cliente;
	
	private String estado;
	
	private String fechaInicio;
	
	private String referencia;
	
	private String vendedorResponsable;
	
	private String direccionCliente;

	public CuentaPorEstadoResultViewModel() {
		
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getVendedorResponsable() {
		return vendedorResponsable;
	}

	public void setVendedorResponsable(String vendedorResponsable) {
		this.vendedorResponsable = vendedorResponsable;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
}
