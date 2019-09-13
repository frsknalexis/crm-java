package com.dev.crm.core.dto;

import java.io.Serializable;

public class DescuentoHistorialRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963154295950006311L;
	
	private String documentopersoma;
	
	private Integer numerodemes;
	
	private Integer aniovalido;
	
	private Double descuentodelmes;
	
	private String motivodeldescuento;
	
	private String codigoUsuario;
	
	public DescuentoHistorialRequest() {
	
	}

	public String getDocumentopersoma() {
		return documentopersoma;
	}

	public void setDocumentopersoma(String documentopersoma) {
		this.documentopersoma = documentopersoma;
	}

	public Integer getNumerodemes() {
		return numerodemes;
	}

	public void setNumerodemes(Integer numerodemes) {
		this.numerodemes = numerodemes;
	}

	public Integer getAniovalido() {
		return aniovalido;
	}

	public void setAniovalido(Integer aniovalido) {
		this.aniovalido = aniovalido;
	}

	public Double getDescuentodelmes() {
		return descuentodelmes;
	}

	public void setDescuentodelmes(Double descuentodelmes) {
		this.descuentodelmes = descuentodelmes;
	}

	public String getMotivodeldescuento() {
		return motivodeldescuento;
	}

	public void setMotivodeldescuento(String motivodeldescuento) {
		this.motivodeldescuento = motivodeldescuento;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
}
