package com.dev.crm.core.dto;

import java.io.Serializable;

public class AsignarTecnicoComboResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;
	
	private String tecnicoescogigo;

	public AsignarTecnicoComboResultViewModel() {
		
	}

	public String getTecnicoescogigo() {
		return tecnicoescogigo;
	}

	public void setTecnicoescogigo(String tecnicoescogigo) {
		this.tecnicoescogigo = tecnicoescogigo;
	}
	
}
