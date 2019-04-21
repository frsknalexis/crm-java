package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmpleadoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5495361453284416691L;

	private BigDecimal codigoEmpleado;
	
	private String documentoPersonaEmpleado;
	
	private Boolean estado;
	
	private CargoDTO cargo;
	
	@JsonIgnore
	private List<EmpleadoInternoDTO> empleadosInternos;
	
	@JsonIgnore
	private List<EmpleadoExternoDTO> empleadosExternos;

	public EmpleadoDTO() {
		
	}

	public BigDecimal getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(BigDecimal codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getDocumentoPersonaEmpleado() {
		return documentoPersonaEmpleado;
	}

	public void setDocumentoPersonaEmpleado(String documentoPersonaEmpleado) {
		this.documentoPersonaEmpleado = documentoPersonaEmpleado;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public CargoDTO getCargo() {
		return cargo;
	}

	public void setCargo(CargoDTO cargo) {
		this.cargo = cargo;
	}

	public List<EmpleadoInternoDTO> getEmpleadosInternos() {
		return empleadosInternos;
	}

	public void setEmpleadosInternos(List<EmpleadoInternoDTO> empleadosInternos) {
		this.empleadosInternos = empleadosInternos;
	}

	public List<EmpleadoExternoDTO> getEmpleadosExternos() {
		return empleadosExternos;
	}

	public void setEmpleadosExternos(List<EmpleadoExternoDTO> empleadosExternos) {
		this.empleadosExternos = empleadosExternos;
	}
}
