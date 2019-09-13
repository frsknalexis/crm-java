package com.dev.crm.core.dto;

import java.io.Serializable;

public class UbigeoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4073781079639445953L;

	private String codigoUbigeo;
	
	private String nombreUbigeo;

	public UbigeoResultViewModel() {
		
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
