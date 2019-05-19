package com.dev.crm.core.dto;

import java.io.Serializable;

public class InsertarReclamoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;

	private String codigousuario;
	
	private String descripcionreclamo;
	
	private String documento;
	
	public InsertarReclamoRequest() {
		
	}

	public String getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(String codigousuario) {
		this.codigousuario = codigousuario;
	}

	public String getDescripcionreclamo() {
		return descripcionreclamo;
	}

	public void setDescripcionreclamo(String descripcionreclamo) {
		this.descripcionreclamo = descripcionreclamo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
}
