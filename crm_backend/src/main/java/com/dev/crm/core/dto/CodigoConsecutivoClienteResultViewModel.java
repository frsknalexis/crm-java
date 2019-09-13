package com.dev.crm.core.dto;

import java.io.Serializable;

public class CodigoConsecutivoClienteResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8924969359320463078L;

	private String documentoCliente;
	
	private String nombreCliente;
	
	private String apellidoPaternoCliente;
	
	private String apellidoMaternoCliente;
	
	private String telefonoCliente;
	
	private String correoCliente;
	
	private String empresaCliente;

	public CodigoConsecutivoClienteResultViewModel() {
		
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoPaternoCliente() {
		return apellidoPaternoCliente;
	}

	public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
		this.apellidoPaternoCliente = apellidoPaternoCliente;
	}

	public String getApellidoMaternoCliente() {
		return apellidoMaternoCliente;
	}

	public void setApellidoMaternoCliente(String apellidoMaternoCliente) {
		this.apellidoMaternoCliente = apellidoMaternoCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getEmpresaCliente() {
		return empresaCliente;
	}

	public void setEmpresaCliente(String empresaCliente) {
		this.empresaCliente = empresaCliente;
	}
}
