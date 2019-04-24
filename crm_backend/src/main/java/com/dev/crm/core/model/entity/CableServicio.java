package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_ca_servicio", schema = "public")
public class CableServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6282227956640262402L;

	@Id
	@Column(name="codi_serca", nullable=false)
	private BigDecimal codigoCableServicio;
	
	@Column(name="fechainicio_serca")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicioCableServicio;
	
	@Column(name="fechatermino_serca")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaTerminoCableServicio;
	
	@Column(name="observacion_serca")
	private String observacionCableServicio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codi_estado", nullable=false)
	private EstadoCuenta estadoCuenta;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codi_tipo_Serv", nullable=false)
	private Servicio servicio;

	public CableServicio() {
		
	}

	public BigDecimal getCodigoCableServicio() {
		return codigoCableServicio;
	}

	public void setCodigoCableServicio(BigDecimal codigoCableServicio) {
		this.codigoCableServicio = codigoCableServicio;
	}

	public Date getFechaInicioCableServicio() {
		return fechaInicioCableServicio;
	}

	public void setFechaInicioCableServicio(Date fechaInicioCableServicio) {
		this.fechaInicioCableServicio = fechaInicioCableServicio;
	}

	public Date getFechaTerminoCableServicio() {
		return fechaTerminoCableServicio;
	}

	public void setFechaTerminoCableServicio(Date fechaTerminoCableServicio) {
		this.fechaTerminoCableServicio = fechaTerminoCableServicio;
	}

	public String getObservacionCableServicio() {
		return observacionCableServicio;
	}

	public void setObservacionCableServicio(String observacionCableServicio) {
		this.observacionCableServicio = observacionCableServicio;
	}

	public EstadoCuenta getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
}
