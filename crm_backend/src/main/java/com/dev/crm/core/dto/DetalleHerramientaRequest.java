package com.dev.crm.core.dto;

import java.io.Serializable;

public class DetalleHerramientaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;

	private String codigousuario;
	
	private Integer codigoherramientareq;
	
	private String preguntadescripcion;
	
	private String descripcionherramienta;

	public DetalleHerramientaRequest() {
		
	}
	
	public String getDescripcionherramienta() {
		return descripcionherramienta;
	}



	public void setDescripcionherramienta(String descripcionherramienta) {
		this.descripcionherramienta = descripcionherramienta;
	}



	public String getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(String codigousuario) {
		this.codigousuario = codigousuario;
	}
	public Integer getCodigoherramientareq() {
		return codigoherramientareq;
	}

	public void setCodigoherramientareq(Integer codigoherramientareq) {
		this.codigoherramientareq = codigoherramientareq;
	}

	public String getPreguntadescripcion() {
		return preguntadescripcion;
	}

	public void setPreguntadescripcion(String preguntadescripcion) {
		this.preguntadescripcion = preguntadescripcion;
	}
	
}
