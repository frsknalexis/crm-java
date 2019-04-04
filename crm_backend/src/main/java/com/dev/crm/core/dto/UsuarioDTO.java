package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class UsuarioDTO extends AuditingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3592699098651945888L;

	private BigDecimal usuarioId;
	
	private String nombreUsuario;
	
	private String passwordUsuario;
	
	private String documentoUsuario;

	public UsuarioDTO() {
		
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
}
