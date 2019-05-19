package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class ReclamoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;
	
	private String codigoreclamo;
	
	private String nombrecliente;
	
	private String direccioncliente;
	
	private String descripcionreclamo;
	
	private Date fechareclamo;
	
	private String hora;

	public ReclamoResultViewModel() {
		
	}

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getDireccioncliente() {
		return direccioncliente;
	}

	public void setDireccioncliente(String direccioncliente) {
		this.direccioncliente = direccioncliente;
	}

	public String getDescripcionreclamo() {
		return descripcionreclamo;
	}

	public void setDescripcionreclamo(String descripcionreclamo) {
		this.descripcionreclamo = descripcionreclamo;
	}

	public Date getFechareclamo() {
		return fechareclamo;
	}

	public void setFechareclamo(Date fechareclamo) {
		this.fechareclamo = fechareclamo;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCodigoreclamo() {
		return codigoreclamo;
	}

	public void setCodigoreclamo(String codigoreclamo) {
		this.codigoreclamo = codigoreclamo;
	}
	
}
