package com.dev.crm.core.dto;

import java.io.Serializable;

public class DeudasPorGestorResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1963620322818460161L;

	private String deuda;
	
	private String direccionCliente;
	
	private String cliente;
	
	private String mesDeuda;

	public DeudasPorGestorResultViewModel() {
		
	}

	public String getDeuda() {
		return deuda;
	}

	public void setDeuda(String deuda) {
		this.deuda = deuda;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getMesDeuda() {
		return mesDeuda;
	}

	public void setMesDeuda(String mesDeuda) {
		this.mesDeuda = mesDeuda;
	}
}
