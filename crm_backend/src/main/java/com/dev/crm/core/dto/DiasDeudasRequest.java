package com.dev.crm.core.dto;

import java.io.Serializable;

public class DiasDeudasRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4735496824727161211L;

	private String diasDeudas;
	
	public DiasDeudasRequest() {

	}

	public String getDiasDeudas() {
		return diasDeudas;
	}

	public void setDiasDeudas(String diasDeudas) {
		this.diasDeudas = diasDeudas;
	}
}
