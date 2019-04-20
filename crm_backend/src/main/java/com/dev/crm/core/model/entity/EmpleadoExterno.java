package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_ci_emp_ext", schema="public")
public class EmpleadoExterno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4079133323069133484L;

	@Id
	@Column(name="codigo_externo", nullable=false, length=6)
	private String codigoExterno;
	
	@Column(name="codigo_empleado")
	private Integer codigoEmpleado;
	
	@Column(name="fecha_activacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActivacion;
	
	@Column(name="fecha_desactivacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDesactivacion;
	
	@Column(name="activo_empext")
	private Boolean estado;
	
	@Column(name="creadopor_empext")
	private String creadoPor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Empleado empleado;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="empleadoExterno")
	private List<Cuenta> cuentas;

	public EmpleadoExterno() {
		cuentas = new ArrayList<Cuenta>();
	}

	public String getCodigoExterno() {
		return codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	public Integer getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(Integer codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public Date getFechaDesactivacion() {
		return fechaDesactivacion;
	}

	public void setFechaDesactivacion(Date fechaDesactivacion) {
		this.fechaDesactivacion = fechaDesactivacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
}
