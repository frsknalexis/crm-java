package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="ubigeo")
	private List<Persona> personas;

	public Ubigeo() {
		personas = new ArrayList<Persona>();
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

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
}
