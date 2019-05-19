package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_ci_cargo", schema="public")
public class Cargo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7606171843507268516L;

	@Id
	@Column(name="codi_cargo", nullable=false, length=4, unique=true)
	private String codigoCargo;
	
	@Column(name="descripcion_cargo", length=50)
	private String descripcionCargo;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="cargo")
	private List<Empleado> empleados;

	public Cargo() {
		empleados = new ArrayList<Empleado>();
	}

	public String getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getDescripcionCargo() {
		return descripcionCargo;
	}

	public void setDescripcionCargo(String descripcionCargo) {
		this.descripcionCargo = descripcionCargo;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
}
