package com.dev.crm.core.dto;

import java.io.Serializable;

public class ObservacionResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3919624995562536111L;
	
	private String observacion;

	public ObservacionResultViewModel() {
		
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
