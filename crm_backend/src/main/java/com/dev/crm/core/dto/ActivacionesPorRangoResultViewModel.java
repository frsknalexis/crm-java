package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class ActivacionesPorRangoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4791930970942043750L;

	private Integer numeracion;
	
	private String cliente;
	
	private String documentoCliente;
	
	private String direccionCliente;
	
	private Date fechaInicioServicio;
	
	private String internet;
	
	private String ubicacion;
	
	private String observacion;

	public ActivacionesPorRangoResultViewModel() {
		
	}

	public Integer getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(Integer numeracion) {
		this.numeracion = numeracion;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public Date getFechaInicioServicio() {
		return fechaInicioServicio;
	}

	public void setFechaInicioServicio(Date fechaInicioServicio) {
		this.fechaInicioServicio = fechaInicioServicio;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
