package com.dev.crm.core.dto;

import java.io.Serializable;

public class ActivacionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 93435974003845063L;

	private String codigo;
	
	public ActivacionRequest() {
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
