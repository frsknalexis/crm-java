package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ci_modulo", schema = "public")
public class Modulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7367311558676668730L;

	@Id
	@Column(name = "numero_modulo", nullable = false)
	private Integer numeroModulo;
	
	@Column(name = "nombre_modulo")
	private String nombreModulo;

	public Modulo() {
		
	}

	public Integer getNumeroModulo() {
		return numeroModulo;
	}

	public void setNumeroModulo(Integer numeroModulo) {
		this.numeroModulo = numeroModulo;
	}

	public String getNombreModulo() {
		return nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}
}
