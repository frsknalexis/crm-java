package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ci_anio", schema = "public")
public class Anio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3828571664586461343L;
	
	@Id
	@Column(name="codi_anio", nullable=false)
	private String codigoAnio;
	
	@Column(name="descripcion_anio", nullable=false)
	private String descripcionAnio;

	public Anio() {
		
	}

	public String getCodigoAnio() {
		return codigoAnio;
	}

	public void setCodigoAnio(String codigoAnio) {
		this.codigoAnio = codigoAnio;
	}

	public String getDescripcionAnio() {
		return descripcionAnio;
	}

	public void setDescripcionAnio(String descripcionAnio) {
		this.descripcionAnio = descripcionAnio;
	}
}
