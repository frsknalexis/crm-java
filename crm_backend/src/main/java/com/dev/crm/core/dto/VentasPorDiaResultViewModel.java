package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class VentasPorDiaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1511429309559893650L;

	private String fechaSolicitudCliente;
	
	private BigDecimal total;

	public VentasPorDiaResultViewModel() {
		
	}

	public String getFechaSolicitudCliente() {
		return fechaSolicitudCliente;
	}

	public void setFechaSolicitudCliente(String fechaSolicitudCliente) {
		this.fechaSolicitudCliente = fechaSolicitudCliente;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
