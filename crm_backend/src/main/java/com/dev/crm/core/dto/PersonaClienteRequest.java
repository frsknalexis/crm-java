package com.dev.crm.core.dto;

import java.io.Serializable;

public class PersonaClienteRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 847140436606693716L;
	
	private String documentoPersonaCliente;
	
	private String apellidoPaternoCliente;
	
	private String apellidoMaternoCliente;
	
	private String nombrePersonaCliente;
	
	private String telefonoUnoCliente;
	
	private String telefonoDosCliente;
	
	private String telefonoTresCliente;

	public PersonaClienteRequest() {
		
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
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

	public String getNombrePersonaCliente() {
		return nombrePersonaCliente;
	}

	public void setNombrePersonaCliente(String nombrePersonaCliente) {
		this.nombrePersonaCliente = nombrePersonaCliente;
	}

	public String getTelefonoUnoCliente() {
		return telefonoUnoCliente;
	}

	public void setTelefonoUnoCliente(String telefonoUnoCliente) {
		this.telefonoUnoCliente = telefonoUnoCliente;
	}

	public String getTelefonoDosCliente() {
		return telefonoDosCliente;
	}

	public void setTelefonoDosCliente(String telefonoDosCliente) {
		this.telefonoDosCliente = telefonoDosCliente;
	}

	public String getTelefonoTresCliente() {
		return telefonoTresCliente;
	}

	public void setTelefonoTresCliente(String telefonoTresCliente) {
		this.telefonoTresCliente = telefonoTresCliente;
	}
}
