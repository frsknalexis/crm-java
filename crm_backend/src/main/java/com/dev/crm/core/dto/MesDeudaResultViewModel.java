package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MesDeudaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4100859598875295063L;
	
	private Integer mesDeuda;
	
	private BigDecimal sumaPago;
	
	private Integer anioValido;
	
	private String tipoServicio;
	
	private Double descuento;
	
	private String documentoPersonaCliente;
	
	private String numeroCaja;

	public MesDeudaResultViewModel() {
		
	}

	public Integer getMesDeuda() {
		return mesDeuda;
	}

	public void setMesDeuda(Integer mesDeuda) {
		this.mesDeuda = mesDeuda;
	}

	public BigDecimal getSumaPago() {
		return sumaPago;
	}

	public void setSumaPago(BigDecimal sumaPago) {
		this.sumaPago = sumaPago;
	}

	public Integer getAnioValido() {
		return anioValido;
	}

	public void setAnioValido(Integer anioValido) {
		this.anioValido = anioValido;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}
}
