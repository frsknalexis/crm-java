package com.dev.crm.core.dto;

import java.io.Serializable;

public class ListaPagosPorCajaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3137201268389268610L;

	private String cliente;
	
	private String marzo;
	
	private String abril;
	
	private String mayo;
	
	private String junio;
	
	private String julio;

	public ListaPagosPorCajaResultViewModel() {
		
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getMarzo() {
		return marzo;
	}

	public void setMarzo(String marzo) {
		this.marzo = marzo;
	}

	public String getAbril() {
		return abril;
	}

	public void setAbril(String abril) {
		this.abril = abril;
	}

	public String getMayo() {
		return mayo;
	}

	public void setMayo(String mayo) {
		this.mayo = mayo;
	}

	public String getJunio() {
		return junio;
	}

	public void setJunio(String junio) {
		this.junio = junio;
	}

	public String getJulio() {
		return julio;
	}

	public void setJulio(String julio) {
		this.julio = julio;
	}
}
