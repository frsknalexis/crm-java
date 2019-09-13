package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ReciboResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6867071197749946207L;

	private String codigoPago;
	
	private String cliente;
	
	private String direccion;
	
	private Date fechaInicio;
	
	private String mesValido;
	
	private Double monto;
	
	private BigDecimal descuento;
	
	private Date fechaPago;
	
	private String tipoComprobante;
	
	private String codigoCliente;
	
	private String documento;
	
	private String sucursal;
	
	private String valorMonto;
	
	private String codigoBarra;

	public ReciboResultViewModel() {
		
	}

	public String getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(String codigoPago) {
		this.codigoPago = codigoPago;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getMesValido() {
		return mesValido;
	}

	public void setMesValido(String mesValido) {
		this.mesValido = mesValido;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getValorMonto() {
		return valorMonto;
	}

	public void setValorMonto(String valorMonto) {
		this.valorMonto = valorMonto;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
}
