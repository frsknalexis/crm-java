package com.dev.crm.core.dto;

import java.io.Serializable;

public class UbigeoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3215533761517591091L;

	private String codigoUbigeo;
	
	private String nombreUbigeo;

	public UbigeoDTO() {
		
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
