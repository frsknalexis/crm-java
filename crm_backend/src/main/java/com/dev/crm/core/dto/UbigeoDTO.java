package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UbigeoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3215533761517591091L;

	private String codigoUbigeo;
	
	private String nombreUbigeo;
	
	@JsonIgnore
	private List<PersonaDTO> personas;

	public UbigeoDTO() {
		personas = new ArrayList<PersonaDTO>();
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

	public List<PersonaDTO> getPersonas() {
		return personas;
	}

	public void setPersonas(List<PersonaDTO> personas) {
		this.personas = personas;
	}
}
