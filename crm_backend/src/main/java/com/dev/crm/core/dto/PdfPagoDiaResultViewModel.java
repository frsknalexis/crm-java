package com.dev.crm.core.dto;

import java.io.Serializable;

public class PdfPagoDiaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;
	
	private String numero_interno_x_dia;
	
	private String codigo_pago_general;
	
	private String nombre_del_mes;
	
	private String monto_pago;
	
	private String fecha_dia_pago;
	
	private String cliente;

	public PdfPagoDiaResultViewModel() {
		
	}

	public String getNumero_interno_x_dia() {
		return numero_interno_x_dia;
	}

	public void setNumero_interno_x_dia(String numero_interno_x_dia) {
		this.numero_interno_x_dia = numero_interno_x_dia;
	}

	public String getCodigo_pago_general() {
		return codigo_pago_general;
	}

	public void setCodigo_pago_general(String codigo_pago_general) {
		this.codigo_pago_general = codigo_pago_general;
	}

	public String getNombre_del_mes() {
		return nombre_del_mes;
	}

	public void setNombre_del_mes(String nombre_del_mes) {
		this.nombre_del_mes = nombre_del_mes;
	}

	public String getMonto_pago() {
		return monto_pago;
	}

	public void setMonto_pago(String monto_pago) {
		this.monto_pago = monto_pago;
	}

	public String getFecha_dia_pago() {
		return fecha_dia_pago;
	}

	public void setFecha_dia_pago(String fecha_dia_pago) {
		this.fecha_dia_pago = fecha_dia_pago;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}	
}
