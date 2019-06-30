package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dev.crm.core.model.base.AuditingEntity;
import com.dev.crm.core.model.base.BaseEntity;

@Entity
@Table(name="tb_ci_usuario", schema="public")
public class Usuario extends AuditingEntity implements Serializable, BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1744572322797598042L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_usuario", unique=true, nullable=false)
	private BigDecimal usuarioId;
	
	@Column(name="nombre_usuario", nullable=false, length=30)
	private String nombreUsuario;
	
	@Column(name="contra_usuario", nullable=false, length=100)
	private String passwordUsuario;
	
	@Column(name = "encrypt_password")
	private String encryptedPassword;
	
	@Column(name="documento_usuario", nullable=false, length=8)
	private String documentoUsuario;

	public Usuario() {
		
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

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getDocumentoUsuario() {
		return documentoUsuario;
	}

	public void setDocumentoUsuario(String documentoUsuario) {
		this.documentoUsuario = documentoUsuario;
	}
}
