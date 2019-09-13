package com.dev.crm.core.dto;

import java.io.Serializable;

public class CuentaPorVendedorResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6093134140800614424L;

	private Integer numeracion;
	
	private String cliente;
	
	private String direccionCliente;
	
	private String estado;
	
	private String fechaInicio;

	public CuentaPorVendedorResultViewModel() {
		
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

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
}
