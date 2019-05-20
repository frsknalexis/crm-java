package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dev.crm.core.json.JsonBigDecimalSimpleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class CorteInternetResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7399753196444581380L;
	
	private Integer codigoServicioInternet;
	
	private String documentoPersonaCliente;
	
	private String cliente;
	
	@JsonSerialize(using=JsonBigDecimalSimpleSerializer.class)
	private BigDecimal deudaTotal;

	public CorteInternetResultViewModel() {
		
	}

	public Integer getCodigoServicioInternet() {
		return codigoServicioInternet;
	}

	public void setCodigoServicioInternet(Integer codigoServicioInternet) {
		this.codigoServicioInternet = codigoServicioInternet;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getDeudaTotal() {
		return deudaTotal;
	}

	public void setDeudaTotal(BigDecimal deudaTotal) {
		this.deudaTotal = deudaTotal;
	}
}
