package com.dev.crm.core.dto;

import java.io.Serializable;

public class GestoresResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 557726008478527694L;

	private String gestor;
	
	private String documentoPersonaGestor;

	public GestoresResultViewModel() {
		
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public String getDocumentoPersonaGestor() {
		return documentoPersonaGestor;
	}

	public void setDocumentoPersonaGestor(String documentoPersonaGestor) {
		this.documentoPersonaGestor = documentoPersonaGestor;
	}
}
