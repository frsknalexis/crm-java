package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class VentasPorVendedorResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7899892806860139518L;

	private String nombreVendedor;
	
	private BigDecimal totalVenta;

	public VentasPorVendedorResultViewModel() {
		
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}
}
