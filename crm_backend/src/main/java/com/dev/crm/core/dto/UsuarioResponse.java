package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class UsuarioResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 279688844892965222L;

	private BigDecimal usuarioId;
	
	private String nombreUsuario;
	
	private String passwordUsuario;
	
	private String documentoUsuario;
	
	private Boolean habilitado;

	public UsuarioResponse() {
		
	}

	public BigDecimal getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(BigDecimal usuarioId) {
		this.usuarioId = usuarioId;
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

	public String getDocumentoUsuario() {
		return documentoUsuario;
	}

	public void setDocumentoUsuario(String documentoUsuario) {
		this.documentoUsuario = documentoUsuario;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
}
