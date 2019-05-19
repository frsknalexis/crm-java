package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_ci_herramienta", schema = "public")
@IdClass(value = HerramientaPK.class)
public class Herramienta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4155905466619082419L;

	@Id
	@Column(name = "codi_herra")
	private Integer codigoHerramienta;
	
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechae_herra")
	private Date fechaRegistroHerramienta;
	
	@Id
	@Column(name = "sec_herra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer secuencialHerramienta;
	
	@Column(name = "descripcion_herra")
	private String descripcionHerramienta;
	
	@Column(name = "pregunta")
	private Integer cantidadPreguntas;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechai_herra")
	private Date fechaInicioHerramienta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaf_herra")
	private Date fechaFinHerramienta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codi_tipherr")
	private TipoHerramienta tipoHerramienta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private EmpleadoInterno empleadoInterno;

	public Herramienta() {
		
	}

	public Integer getCodigoHerramienta() {
		return codigoHerramienta;
	}

	public void setCodigoHerramienta(Integer codigoHerramienta) {
		this.codigoHerramienta = codigoHerramienta;
	}

	public Date getFechaRegistroHerramienta() {
		return fechaRegistroHerramienta;
	}

	public void setFechaRegistroHerramienta(Date fechaRegistroHerramienta) {
		this.fechaRegistroHerramienta = fechaRegistroHerramienta;
	}

	public Integer getSecuencialHerramienta() {
		return secuencialHerramienta;
	}

	public void setSecuencialHerramienta(Integer secuencialHerramienta) {
		this.secuencialHerramienta = secuencialHerramienta;
	}

	public String getDescripcionHerramienta() {
		return descripcionHerramienta;
	}

	public void setDescripcionHerramienta(String descripcionHerramienta) {
		this.descripcionHerramienta = descripcionHerramienta;
	}

	public Integer getCantidadPreguntas() {
		return cantidadPreguntas;
	}

	public void setCantidadPreguntas(Integer cantidadPreguntas) {
		this.cantidadPreguntas = cantidadPreguntas;
	}

	public Date getFechaInicioHerramienta() {
		return fechaInicioHerramienta;
	}

	public void setFechaInicioHerramienta(Date fechaInicioHerramienta) {
		this.fechaInicioHerramienta = fechaInicioHerramienta;
	}

	public Date getFechaFinHerramienta() {
		return fechaFinHerramienta;
	}

	public void setFechaFinHerramienta(Date fechaFinHerramienta) {
		this.fechaFinHerramienta = fechaFinHerramienta;
	}

	public TipoHerramienta getTipoHerramienta() {
		return tipoHerramienta;
	}

	public void setTipoHerramienta(TipoHerramienta tipoHerramienta) {
		this.tipoHerramienta = tipoHerramienta;
	}

	public EmpleadoInterno getEmpleadoInterno() {
		return empleadoInterno;
	}

	public void setEmpleadoInterno(EmpleadoInterno empleadoInterno) {
		this.empleadoInterno = empleadoInterno;
	}
}
