package com.dev.crm.core.dto;

import java.io.Serializable;

public class DatosClienteResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627693221892732169L;

	private String documentoPersonaCliente;
	
	private String apellidoPaternoCliente;
	
	private String apellidoMaternoCliente;
	
	private String nombresCliente;
	
	private String telefonoUnoCliente;
	
	private String telefonoDosCliente;
	
	private String telefonoTresCliente;
	
	private String direccionActualCliente;

	public DatosClienteResultViewModel() {
		
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

	public String getNombresCliente() {
		return nombresCliente;
	}

	public void setNombresCliente(String nombresCliente) {
		this.nombresCliente = nombresCliente;
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

	public String getDireccionActualCliente() {
		return direccionActualCliente;
	}

	public void setDireccionActualCliente(String direccionActualCliente) {
		this.direccionActualCliente = direccionActualCliente;
	}
}
