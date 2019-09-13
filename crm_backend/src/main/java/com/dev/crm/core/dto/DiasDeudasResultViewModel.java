package com.dev.crm.core.dto;

import java.io.Serializable;

public class DiasDeudasResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5918813111497165548L;

	private Integer numeracion;
	
	private Integer codigoCuenta;
	
	private String documentoPersonaCliente;
	
	private String mesPago;
	
	private String direccionCliente;
	
	private String cliente;
		
	public DiasDeudasResultViewModel() {
		
	}

	public Integer getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(Integer numeracion) {
		this.numeracion = numeracion;
	}
	
	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getMesPago() {
		return mesPago;
	}

	public void setMesPago(String mesPago) {
		this.mesPago = mesPago;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
