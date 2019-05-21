package com.dev.crm.core.dto;

import java.io.Serializable;

public class UsuarioRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8520801659840878923L;

	private String nombreUsuario;
	
	private String passwordUsuario;

	public UsuarioRequest() {
		
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
}
