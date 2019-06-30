package com.dev.crm.core.dto;

import java.io.Serializable;

public class InformeInstalacionDiaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3230993574916500034L;

	private Integer codigoDetalleCuenta;
	
	private String documentoPersonaCliente;
	
	private Integer codigoCuenta;
	
	private String estadoInstalacion;
	
	private String cliente;
	
	private String tecnicoResponsable;

	public InformeInstalacionDiaResultViewModel() {
		
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

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getEstadoInstalacion() {
		return estadoInstalacion;
	}

	public void setEstadoInstalacion(String estadoInstalacion) {
		this.estadoInstalacion = estadoInstalacion;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTecnicoResponsable() {
		return tecnicoResponsable;
	}

	public void setTecnicoResponsable(String tecnicoResponsable) {
		this.tecnicoResponsable = tecnicoResponsable;
	}
}
