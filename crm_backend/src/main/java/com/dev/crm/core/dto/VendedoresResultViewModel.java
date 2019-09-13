package com.dev.crm.core.dto;

import java.io.Serializable;

public class VendedoresResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7207855932840290156L;
	
	private String vendedor;
	
	private String documentoPersonaVendedor;

	public VendedoresResultViewModel() {
		
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getDocumentoPersonaVendedor() {
		return documentoPersonaVendedor;
	}

	public void setDocumentoPersonaVendedor(String documentoPersonaVendedor) {
		this.documentoPersonaVendedor = documentoPersonaVendedor;
	}
}
