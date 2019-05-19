package com.dev.crm.core.dto;

import java.io.Serializable;

public class EditarPreguntaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;

	private Integer codigoherramienta;
	
	private Integer codigodetalleherramienta;
	
	private String pregunta;
	
	public EditarPreguntaRequest() {
		
	}

	public Integer getCodigoherramienta() {
		return codigoherramienta;
	}

	public void setCodigoherramienta(Integer codigoherramienta) {
		this.codigoherramienta = codigoherramienta;
	}

	public Integer getCodigodetalleherramienta() {
		return codigodetalleherramienta;
	}

	public void setCodigodetalleherramienta(Integer codigodetalleherramienta) {
		this.codigodetalleherramienta = codigodetalleherramienta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
}
