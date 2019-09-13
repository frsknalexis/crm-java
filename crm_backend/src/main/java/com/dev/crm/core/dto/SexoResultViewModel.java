package com.dev.crm.core.dto;

import java.io.Serializable;

public class SexoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -132004137975509640L;

	private Integer codigoSexo;
	
	private String descripcionSexo;

	public SexoResultViewModel() {
		
	}

	public Integer getCodigoSexo() {
		return codigoSexo;
	}

	public void setCodigoSexo(Integer codigoSexo) {
		this.codigoSexo = codigoSexo;
	}

	public String getDescripcionSexo() {
		return descripcionSexo;
	}

	public void setDescripcionSexo(String descripcionSexo) {
		this.descripcionSexo = descripcionSexo;
	}
}
