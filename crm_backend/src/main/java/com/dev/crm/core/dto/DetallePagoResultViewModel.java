package com.dev.crm.core.dto;

import java.io.Serializable;

public class DetallePagoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;
	
	private Double totalpago;
	
	private Float descuentototal;
	
	private Float cantidadpago;
	
	private String fechadepago;
	
	private String informacionpago;

	public DetallePagoResultViewModel() {
		
	}

	public Double getTotalpago() {
		return totalpago;
	}

	public void setTotalpago(Double totalpago) {
		this.totalpago = totalpago;
	}

	public Float getDescuentototal() {
		return descuentototal;
	}

	public void setDescuentototal(Float descuentototal) {
		this.descuentototal = descuentototal;
	}

	public Float getCantidadpago() {
		return cantidadpago;
	}

	public void setCantidadpago(Float cantidadpago) {
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
	
}
