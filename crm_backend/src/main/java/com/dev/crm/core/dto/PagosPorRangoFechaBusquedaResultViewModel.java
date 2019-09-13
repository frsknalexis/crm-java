package com.dev.crm.core.dto;

import java.io.Serializable;

public class PagosPorRangoFechaBusquedaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5617868180876462592L;

	private String numeracion;
	
	private String codigoPago;
	
	private String mesPago;
	
	private String cantidadPago;
	
	private String fechaPagoDia;
	
	private String cliente;

	public PagosPorRangoFechaBusquedaResultViewModel() {
		
	}
	
	public String getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}
	
	public String getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(String codigoPago) {
		this.codigoPago = codigoPago;
	}

	public String getMesPago() {
		return mesPago;
	}

	public void setMesPago(String mesPago) {
		this.mesPago = mesPago;
	}

	public String getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(String cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public String getFechaPagoDia() {
		return fechaPagoDia;
	}

	public void setFechaPagoDia(String fechaPagoDia) {
		this.fechaPagoDia = fechaPagoDia;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
