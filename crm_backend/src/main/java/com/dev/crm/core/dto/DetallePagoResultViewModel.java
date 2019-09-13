package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dev.crm.core.json.JsonBigDecimalSimpleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class DetallePagoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;
	
	private Double totalpago;
	
	@JsonSerialize(using = JsonBigDecimalSimpleSerializer.class)
	private BigDecimal descuentototal;
	
	@JsonSerialize(using = JsonBigDecimalSimpleSerializer.class)
	private BigDecimal cantidadpago;
	
	private String fechadepago;
	
	private String informacionpago;
	
	private String codigocajapago;

	public DetallePagoResultViewModel() {
		
	}

	public Double getTotalpago() {
		return totalpago;
	}

	public void setTotalpago(Double totalpago) {
		this.totalpago = totalpago;
	}

	public BigDecimal getDescuentototal() {
		return descuentototal;
	}

	public void setDescuentototal(BigDecimal descuentototal) {
		this.descuentototal = descuentototal;
	}

	public BigDecimal getCantidadpago() {
		return cantidadpago;
	}

	public void setCantidadpago(BigDecimal cantidadpago) {
		this.cantidadpago = cantidadpago;
	}

	public String getFechadepago() {
		return fechadepago;
	}

	public void setFechadepago(String fechadepago) {
		this.fechadepago = fechadepago;
	}

	public String getInformacionpago() {
		return informacionpago;
	}

	public void setInformacionpago(String informacionpago) {
		this.informacionpago = informacionpago;
	}

	public String getCodigocajapago() {
		return codigocajapago;
	}

	public void setCodigocajapago(String codigocajapago) {
		this.codigocajapago = codigocajapago;
	}
}
