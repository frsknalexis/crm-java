package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class EditarHerramientaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;

	private String herramienta;
	
	private String descripcionherramienta;
	
	private Date fechainicio;
	
	private Date fechafinal;
	
	private Integer CodigoUusario;
	
	private Integer CodigoTipoComprobante;
	
	private Integer Cantidad;
	
	private Integer Secuencial;
	
	private Date Fechaemision;
	

	public EditarHerramientaResultViewModel() {
		
	}


	public String getHerramienta() {
		return herramienta;
	}


	public void setHerramienta(String herramienta) {
		this.herramienta = herramienta;
	}


	public String getDescripcionherramienta() {
		return descripcionherramienta;
	}


	public void setDescripcionherramienta(String descripcionherramienta) {
		this.descripcionherramienta = descripcionherramienta;
	}


	public Date getFechainicio() {
		return fechainicio;
	}


	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}


	public Date getFechafinal() {
		return fechafinal;
	}


	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}


	public Integer getCodigoUusario() {
		return CodigoUusario;
	}


	public void setCodigoUusario(Integer codigoUusario) {
		CodigoUusario = codigoUusario;
	}


	public Integer getCodigoTipoComprobante() {
		return CodigoTipoComprobante;
	}


	public void setCodigoTipoComprobante(Integer codigoTipoComprobante) {
		CodigoTipoComprobante = codigoTipoComprobante;
	}


	public Integer getCantidad() {
		return Cantidad;
	}


	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}


	public Integer getSecuencial() {
		return Secuencial;
	}


	public void setSecuencial(Integer secuencial) {
		Secuencial = secuencial;
	}


	public Date getFechaemision() {
		return Fechaemision;
	}


	public void setFechaemision(Date fechaemision) {
		Fechaemision = fechaemision;
	}
	
	
	
}
