package com.dev.crm.core.dto;

import java.io.Serializable;

public class MensajeNotiResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -192569864502908955L;

	
	private String nombrepersona;
	
	private String descripcionmensaje;

	public MensajeNotiResultViewModel() {
		
	}

	public String getNombrepersona() {
		return nombrepersona;
	}

	public void setNombrepersona(String nombrepersona) {
		this.nombrepersona = nombrepersona;
	}

	public String getDescripcionmensaje() {
		return descripcionmensaje;
	}

	public void setDescripcionmensaje(String descripcionmensaje) {
		this.descripcionmensaje = descripcionmensaje;
	}
	
}
