package com.dev.crm.core.dto;

import java.io.Serializable;

public class EmpleadoEXTINTResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6061319826634754568L;
	
	private String documentopersonaempleado;
	
	private String codigoempleado;
	
	private String empleadonombre;
	
	private String direccionempleado;
	
	private String telefonoprinciaplempleado;
	
	private String cargoempleado;
	
	private Integer valueestado;
	
	private Integer activointerno;
	
	private Integer activoexterno;

	public EmpleadoEXTINTResultViewModel() {
		
	}

	public String getDocumentopersonaempleado() {
		return documentopersonaempleado;
	}

	public void setDocumentopersonaempleado(String documentopersonaempleado) {
		this.documentopersonaempleado = documentopersonaempleado;
	}

	public String getCodigoempleado() {
		return codigoempleado;
	}

	public void setCodigoempleado(String codigoempleado) {
		this.codigoempleado = codigoempleado;
	}

	public String getEmpleadonombre() {
		return empleadonombre;
	}

	public void setEmpleadonombre(String empleadonombre) {
		this.empleadonombre = empleadonombre;
	}

	public String getDireccionempleado() {
		return direccionempleado;
	}

	public void setDireccionempleado(String direccionempleado) {
		this.direccionempleado = direccionempleado;
	}

	public String getTelefonoprinciaplempleado() {
		return telefonoprinciaplempleado;
	}

	public void setTelefonoprinciaplempleado(String telefonoprinciaplempleado) {
		this.telefonoprinciaplempleado = telefonoprinciaplempleado;
	}

	public String getCargoempleado() {
		return cargoempleado;
	}

	public void setCargoempleado(String cargoempleado) {
		this.cargoempleado = cargoempleado;
	}

	public Integer getValueestado() {
		return valueestado;
	}

	public void setValueestado(Integer valueestado) {
		this.valueestado = valueestado;
	}

	public Integer getActivointerno() {
		return activointerno;
	}

	public void setActivointerno(Integer activointerno) {
		this.activointerno = activointerno;
	}

	public Integer getActivoexterno() {
		return activoexterno;
	}

	public void setActivoexterno(Integer activoexterno) {
		this.activoexterno = activoexterno;
	}
	
}
