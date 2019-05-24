package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PagoMoraRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3139328109654237156L;

	private String documentoPersonaClienteDeuda;
	
	private BigDecimal codigoComprobanteDeuda;
	
	private String documentoPersonaPagoDeuda;
	
	private Double cantidadPagoDeuda;
	
	private String numeroCaja;
	
	private String tipoServicio;
	
	private Double montoPagoDeuda;
	
	private Double descuento;
	
	private Integer anioValido;
	
	private Integer mes;
	
	private String codigousuario;

	public PagoMoraRequest() {
		
	}

	public String getDocumentoPersonaClienteDeuda() {
		return documentoPersonaClienteDeuda;
	}

	public void setDocumentoPersonaClienteDeuda(String documentoPersonaClienteDeuda) {
		this.documentoPersonaClienteDeuda = documentoPersonaClienteDeuda;
	}

	public BigDecimal getCodigoComprobanteDeuda() {
		return codigoComprobanteDeuda;
	}

	public void setCodigoComprobanteDeuda(BigDecimal codigoComprobanteDeuda) {
		this.codigoComprobanteDeuda = codigoComprobanteDeuda;
	}

	public String getDocumentoPersonaPagoDeuda() {
		return documentoPersonaPagoDeuda;
	}

	public void setDocumentoPersonaPagoDeuda(String documentoPersonaPagoDeuda) {
		this.documentoPersonaPagoDeuda = documentoPersonaPagoDeuda;
	}

	public Double getCantidadPagoDeuda() {
		return cantidadPagoDeuda;
	}

	public void setCantidadPagoDeuda(Double cantidadPagoDeuda) {
		this.cantidadPagoDeuda = cantidadPagoDeuda;
	}

	public String getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Double getMontoPagoDeuda() {
		return montoPagoDeuda;
	}

	public void setMontoPagoDeuda(Double montoPagoDeuda) {
		this.montoPagoDeuda = montoPagoDeuda;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Integer getAnioValido() {
		return anioValido;
	}

	public void setAnioValido(Integer anioValido) {
		this.anioValido = anioValido;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public String getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(String codigousuario) {
		this.codigousuario = codigousuario;
	}
	
}
