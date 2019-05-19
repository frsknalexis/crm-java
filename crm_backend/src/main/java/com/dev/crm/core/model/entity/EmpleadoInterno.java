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
@Table(name="tb_ci_emp_int", schema="public")
public class EmpleadoInterno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6850818370463050569L;
	
	@Id
	@Column(name="codigo_interno", nullable=false, length=6)
	private String codigoInterno;
	
	@Column(name="codigo_empleado")
	private Integer codigoEmpleado;
	
	@Column(name="fecha_activacioni")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActivacion;
	
	@Column(name="fecha_desactivacioni")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDesactivacion;
	
	@Column(name="activo_empint")
	private Boolean estado;
	
	@Column(name="creadopor_empint")
	private String creadoPor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Empleado empleado;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="empleadoInterno")
	private List<Pago> pagos;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empleadoInterno")
	private List<Herramienta> herramientas;

	public EmpleadoInterno() {
		pagos = new ArrayList<Pago>();
		herramientas = new ArrayList<Herramienta>();
	}

	public String getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
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

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<Herramienta> getHerramientas() {
		return herramientas;
	}

	public void setHerramientas(List<Herramienta> herramientas) {
		this.herramientas = herramientas;
	}
}
