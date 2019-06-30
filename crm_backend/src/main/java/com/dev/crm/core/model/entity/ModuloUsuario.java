package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ci_modulo_usuario", schema = "public")
public class ModuloUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7341870412607973737L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer moduloUsuarioId;
	
	@Column(name = "numero_modulo")
	private Integer numeroModulo;

	@Column(name = "estado_uso")
	private Integer estadoUsuarioModulo;
	
	@Column(name = "documento_usuario")
	private String documentoUsuario;

	public ModuloUsuario() {
		
	}

	public Integer getModuloUsuarioId() {
		return moduloUsuarioId;
	}

	public void setModuloUsuarioId(Integer moduloUsuarioId) {
		this.moduloUsuarioId = moduloUsuarioId;
	}

	public Integer getNumeroModulo() {
		return numeroModulo;
	}

	public void setNumeroModulo(Integer numeroModulo) {
		this.numeroModulo = numeroModulo;
	}

	public Integer getEstadoUsuarioModulo() {
		return estadoUsuarioModulo;
	}

	public void setEstadoUsuarioModulo(Integer estadoUsuarioModulo) {
		this.estadoUsuarioModulo = estadoUsuarioModulo;
	}

	public String getDocumentoUsuario() {
		return documentoUsuario;
	}

	public void setDocumentoUsuario(String documentoUsuario) {
		this.documentoUsuario = documentoUsuario;
	}
}
