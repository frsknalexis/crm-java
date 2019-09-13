package com.dev.crm.core.dto;

import java.io.Serializable;

public class PagoPorDiaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3022034117941764961L;

	private String numeroInterno;
	
	private String codigoPago;
	
	private String mesPago;
	
	private String cantidadPago;
	
	private String fechaPago;
	
	private String cliente;

	public PagoPorDiaResultViewModel() {
		
	}

	public String getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(String numeroInterno) {
		this.numeroInterno = numeroInterno;
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

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
