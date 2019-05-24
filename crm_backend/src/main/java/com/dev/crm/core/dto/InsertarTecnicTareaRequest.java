package com.dev.crm.core.dto;

import java.io.Serializable;

public class InsertarTecnicTareaRequest implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = -8918888252821672128L;

	private String datovaluar;
	
	private String codigo;
	
	private String descripciontarea;
	
	private String codigousuario;
	
	public InsertarTecnicTareaRequest() {
		
	}

	public String getDatovaluar() {
		return datovaluar;
	}

	public void setDatovaluar(String datovaluar) {
		this.datovaluar = datovaluar;
	}

	public String getDescripciontarea() {
		return descripciontarea;
	}

	public void setDescripciontarea(String descripciontarea) {
		this.descripciontarea = descripciontarea;
	}

	public String getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(String codigousuario) {
		this.codigousuario = codigousuario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
