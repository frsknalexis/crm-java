package com.dev.crm.core.model.entity;

import java.io.Serializable;
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
@Table(name = "tb_ci_reclamo", schema = "public")
public class Reclamo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7846979601323135193L;

	@Id
	@Column(name = "codi_recl", nullable = false)
	private Integer codigoReclamo;
	
	@Column(name = "descripcion_reclamo")
	private String descripcionReclamo;
	
	@Column(name = "fechar_reclamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaReclamo;
	
	@Column(name = "horar_reclamo")
	@Temporal(TemporalType.TIME)
	private Date horaReclamo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codi_estado")
	private EstadoReclamoDetalle estadoReclamoDetalle;
	
	@Column(name = "cons_cliente")
	private Integer consecutivoCliente;
	
	@Column(name = "codigo_interno")
	private String codigoInterno;

	public Reclamo() {
		
	}

	public Integer getCodigoReclamo() {
		return codigoReclamo;
	}

	public void setCodigoReclamo(Integer codigoReclamo) {
		this.codigoReclamo = codigoReclamo;
	}

	public String getDescripcionReclamo() {
		return descripcionReclamo;
	}

	public void setDescripcionReclamo(String descripcionReclamo) {
		this.descripcionReclamo = descripcionReclamo;
	}

	public Date getFechaReclamo() {
		return fechaReclamo;
	}

	public void setFechaReclamo(Date fechaReclamo) {
		this.fechaReclamo = fechaReclamo;
	}

	public Date getHoraReclamo() {
		return horaReclamo;
	}

	public void setHoraReclamo(Date horaReclamo) {
		this.horaReclamo = horaReclamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EstadoReclamoDetalle getEstadoReclamoDetalle() {
		return estadoReclamoDetalle;
	}

	public void setEstadoReclamoDetalle(EstadoReclamoDetalle estadoReclamoDetalle) {
		this.estadoReclamoDetalle = estadoReclamoDetalle;
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
	}

	public String getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
}
