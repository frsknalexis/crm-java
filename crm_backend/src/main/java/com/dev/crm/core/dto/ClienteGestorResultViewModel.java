package com.dev.crm.core.dto;

import java.io.Serializable;

public class ClienteGestorResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2620434850908286759L;
	
	private String documentoPersonaCliente;
	
	private Integer consecutivoCliente;
	
	private String cliente;
	
	private String gestor;
	
	private String direccionActualCliente;

	public ClienteGestorResultViewModel() {
		
	}
	
	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}
	
	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public String getDireccionActualCliente() {
		return direccionActualCliente;
	}

	public void setDireccionActualCliente(String direccionActualCliente) {
		this.direccionActualCliente = direccionActualCliente;
	}
}
