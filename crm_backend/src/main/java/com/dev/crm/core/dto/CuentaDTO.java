package com.dev.crm.core.dto;

import java.io.Serializable;

public class CuentaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 482335202763737100L;

	private String documentoPersonaCliente;
	
	private Integer codigoCuenta;
	
	private String codigoAnio;
	
	private Integer consecutivoCliente;
	
	private EmpleadoExternoDTO empleadoExterno;

	public CuentaDTO() {
		
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

	public String getCodigoAnio() {
		return codigoAnio;
	}

	public void setCodigoAnio(String codigoAnio) {
		this.codigoAnio = codigoAnio;
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
	}

	public EmpleadoExternoDTO getEmpleadoExterno() {
		return empleadoExterno;
	}

	public void setEmpleadoExterno(EmpleadoExternoDTO empleadoExterno) {
		this.empleadoExterno = empleadoExterno;
	}
}
