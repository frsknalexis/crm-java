package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_ci_empleado", schema="public")
@IdClass(value=EmpleadoPK.class)
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5930630574068721114L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_empleado", nullable=false, unique=true)
	private BigDecimal codigoEmpleado;
	
	@Id
	@Column(name="documento_personae", nullable=false, length=11)
	private String documentoPersonaEmpleado;
	
	@Column(name="activo_empleado")
	private Boolean estado;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codi_cargo", nullable=false)
	private Cargo cargo;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="empleado")
	private List<EmpleadoInterno> empleadosInternos;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="empleado")
	private List<EmpleadoExterno> empleadosExternos;

	public Empleado() {
		empleadosInternos = new ArrayList<EmpleadoInterno>();
		empleadosExternos = new ArrayList<EmpleadoExterno>();
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<EmpleadoInterno> getEmpleadosInternos() {
		return empleadosInternos;
	}

	public void setEmpleadosInternos(List<EmpleadoInterno> empleadosInternos) {
		this.empleadosInternos = empleadosInternos;
	}

	public List<EmpleadoExterno> getEmpleadosExternos() {
		return empleadosExternos;
	}

	public void setEmpleadosExternos(List<EmpleadoExterno> empleadosExternos) {
		this.empleadosExternos = empleadosExternos;
	}
}
