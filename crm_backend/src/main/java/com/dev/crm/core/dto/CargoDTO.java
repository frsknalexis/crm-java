package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CargoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8875458392102013130L;

	private BigDecimal codigoCargo;
	
	private String descripcionCargo;
	
	@JsonIgnore
	private List<EmpleadoDTO> empleados;

	public CargoDTO() {
		empleados = new ArrayList<EmpleadoDTO>();
	}

	public BigDecimal getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(BigDecimal codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getDescripcionCargo() {
		return descripcionCargo;
	}

	public void setDescripcionCargo(String descripcionCargo) {
		this.descripcionCargo = descripcionCargo;
	}

	public List<EmpleadoDTO> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadoDTO> empleados) {
		this.empleados = empleados;
	}
}

