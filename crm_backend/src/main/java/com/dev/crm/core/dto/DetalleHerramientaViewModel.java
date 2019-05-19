package com.dev.crm.core.dto;

import java.io.Serializable;

public class DetalleHerramientaViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;
	
	private String pregunta;
	
	private Integer codigodetalle;
	
	private Integer cogidoherramienta;
	
	private Integer secuencial;

	public DetalleHerramientaViewModel() {
		
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Integer getCodigodetalle() {
		return codigodetalle;
	}

	public void setCodigodetalle(Integer codigodetalle) {
		this.codigodetalle = codigodetalle;
	}

	public Integer getCogidoherramienta() {
		return cogidoherramienta;
	}

	public void setCogidoherramienta(Integer cogidoherramienta) {
		this.cogidoherramienta = cogidoherramienta;
	}

	public Integer getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}
	
}
