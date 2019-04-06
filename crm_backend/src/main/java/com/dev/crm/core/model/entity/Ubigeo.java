package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_ci_ubigeo", schema="public")
public class Ubigeo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4579625188084002847L;
	
	@Id
	@Column(name="codigo_ubigeo", nullable=false, length=6, unique=true)
	private String codigoUbigeo;
	
	@Column(name="nombre_ubigeo", length=50, nullable=false)
	private String nombreUbigeo;

	public Ubigeo() {
		
	}

	public String getCodigoUbigeo() {
		return codigoUbigeo;
	}

	public void setCodigoUbigeo(String codigoUbigeo) {
		this.codigoUbigeo = codigoUbigeo;
	}

	public String getNombreUbigeo() {
		return nombreUbigeo;
	}

	public void setNombreUbigeo(String nombreUbigeo) {
		this.nombreUbigeo = nombreUbigeo;
	}
}
