package com.dev.crm.core.dto;

import java.io.Serializable;

public class ObtenernumerotareaRequest implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = -8918888252821672128L;

	private String datovaluar;
	
	public ObtenernumerotareaRequest() {
		
	}

	public String getDatovaluar() {
		return datovaluar;
	}

	public void setDatovaluar(String datovaluar) {
		this.datovaluar = datovaluar;
	}

	
}
