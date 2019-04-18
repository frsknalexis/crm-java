package com.dev.crm.core.dto;

import java.io.Serializable;

public class EmpleadoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String documentoPersonaEmpleado;
	
	private String empleado;
	
	private String direccionPersonaEmpleado;
	
	private String telefonoPersonaEmpleado;
	
	private String descripcionCargo;
	
	private Integer value; 
	
	private Integer tof;
	
	private Integer fot;

	public EmpleadoResultViewModel() {
		
	}

	public String getDocumentoPersonaEmpleado() {
		return documentoPersonaEmpleado;
	}

	public void setDocumentoPersonaEmpleado(String documentoPersonaEmpleado) {
		this.documentoPersonaEmpleado = documentoPersonaEmpleado;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getDireccionPersonaEmpleado() {
		return direccionPersonaEmpleado;
	}

	public void setDireccionPersonaEmpleado(String direccionPersonaEmpleado) {
		this.direccionPersonaEmpleado = direccionPersonaEmpleado;
	}

	public String getTelefonoPersonaEmpleado() {
		return telefonoPersonaEmpleado;
	}

	public void setTelefonoPersonaEmpleado(String telefonoPersonaEmpleado) {
		this.telefonoPersonaEmpleado = telefonoPersonaEmpleado;
	}

	public String getDescripcionCargo() {
		return descripcionCargo;
	}

	public void setDescripcionCargo(String descripcionCargo) {
		this.descripcionCargo = descripcionCargo;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getTof() {
		return tof;
	}

	public void setTof(Integer tof) {
		this.tof = tof;
	}

	public Integer getFot() {
		return fot;
	}

	public void setFot(Integer fot) {
		this.fot = fot;
	}	
}
