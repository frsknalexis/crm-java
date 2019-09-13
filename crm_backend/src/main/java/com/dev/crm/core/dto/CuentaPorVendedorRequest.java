package com.dev.crm.core.dto;

import java.io.Serializable;

public class CuentaPorVendedorRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6862512451185942699L;

	private String vendedorResponsable;

	public CuentaPorVendedorRequest() {
		
	}

	public String getVendedorResponsable() {
		return vendedorResponsable;
	}

	public void setVendedorResponsable(String vendedorResponsable) {
		this.vendedorResponsable = vendedorResponsable;
	}
}
