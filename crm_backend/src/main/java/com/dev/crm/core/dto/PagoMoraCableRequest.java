package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PagoMoraCableRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4913713468767661557L;

	private String documentoPersonaClienteDeuda;
	
	private String tipoServicio;
	
	private Integer codigoComprobanteDeuda;
	
	private BigDecimal descuento;
	
	private String documentoPersonaPagoDeuda;
	
	private BigDecimal montoDeuda;
	
	private BigDecimal montoPago;
	
	private Integer mesPago;
	
	private String codigoCaja;
	
	private String aniValidoPago;

	public PagoMoraCableRequest() {
		
	}

	public String getDocumentoPersonaClienteDeuda() {
		return documentoPersonaClienteDeuda;
	}

	public void setDocumentoPersonaClienteDeuda(String documentoPersonaClienteDeuda) {
		this.documentoPersonaClienteDeuda = documentoPersonaClienteDeuda;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Integer getCodigoComprobanteDeuda() {
		return codigoComprobanteDeuda;
	}

	public void setCodigoComprobanteDeuda(Integer codigoComprobanteDeuda) {
		this.codigoComprobanteDeuda = codigoComprobanteDeuda;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public String getDocumentoPersonaPagoDeuda() {
		return documentoPersonaPagoDeuda;
	}

	public void setDocumentoPersonaPagoDeuda(String documentoPersonaPagoDeuda) {
		this.documentoPersonaPagoDeuda = documentoPersonaPagoDeuda;
	}

	public BigDecimal getMontoDeuda() {
		return montoDeuda;
	}

	public void setMontoDeuda(BigDecimal montoDeuda) {
		this.montoDeuda = montoDeuda;
	}

	public BigDecimal getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(BigDecimal montoPago) {
		this.montoPago = montoPago;
	}

	public Integer getMesPago() {
		return mesPago;
	}

	public void setMesPago(Integer mesPago) {
		this.mesPago = mesPago;
	}

	public String getCodigoCaja() {
		return codigoCaja;
	}

	public void setCodigoCaja(String codigoCaja) {
		this.codigoCaja = codigoCaja;
	}

	public String getAniValidoPago() {
		return aniValidoPago;
	}

	public void setAniValidoPago(String aniValidoPago) {
		this.aniValidoPago = aniValidoPago;
	}
	
	
}
