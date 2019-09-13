package com.dev.crm.core.dto;

import java.io.Serializable;

public class UsuarioPerfilRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2429583823798122895L;

	private String passwordActual;
	
	private String encryptedPasswordActual;
	
	private String usuario;

	public UsuarioPerfilRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPasswordActual() {
		return passwordActual;
	}

	public void setPasswordActual(String passwordActual) {
		this.passwordActual = passwordActual;
	}

	public String getEncryptedPasswordActual() {
		return encryptedPasswordActual;
	}

	public void setEncryptedPasswordActual(String encryptedPasswordActual) {
		this.encryptedPasswordActual = encryptedPasswordActual;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
