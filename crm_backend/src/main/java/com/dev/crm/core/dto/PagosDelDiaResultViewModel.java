package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PagosDelDiaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7619007752896269752L;
	
	private Integer codigoPago;
	
	private BigDecimal descuento;
	
	private BigDecimal cantidadPago;
	
	private String mesValido;
	
	private String anioValido;
	
	private String cliente;
	
	private String direccionActualCliente;
	
	private Date fechaPagoDia;

	public PagosDelDiaResultViewModel() {
		
	}

	public Integer getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(Integer codigoPago) {
		this.codigoPago = codigoPago;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public String getMesValido() {
		return mesValido;
	}

	public void setMesValido(String mesValido) {
		this.mesValido = mesValido;
	}

	public String getAnioValido() {
		return anioValido;
	}

	public void setAnioValido(String anioValido) {
		this.anioValido = anioValido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccionActualCliente() {
		return direccionActualCliente;
	}

	public void setDireccionActualCliente(String direccionActualCliente) {
		this.direccionActualCliente = direccionActualCliente;
	}

	public Date getFechaPagoDia() {
		return fechaPagoDia;
	}

	public void setFechaPagoDia(Date fechaPagoDia) {
		this.fechaPagoDia = fechaPagoDia;
	}
}
