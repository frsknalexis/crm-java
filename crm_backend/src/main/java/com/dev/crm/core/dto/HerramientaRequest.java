package com.dev.crm.core.dto;

import java.io.Serializable;

public class HerramientaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;

	private String observacion;
	
	private String cantidad;
	
	private String fechainicio;
	
	private String fechafinal;
	
	private String tipoherramienta;
	
	private String mensaje;


	public HerramientaRequest() {
		
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getFechainicio() {
		return fechainicio;
	}


	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}


	public String getFechafinal() {
		return fechafinal;
	}


	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}


	public String getTipoherramienta() {
		return tipoherramienta;
	}


	public void setTipoherramienta(String tipoherramienta) {
		this.tipoherramienta = tipoherramienta;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
