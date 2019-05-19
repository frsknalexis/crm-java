package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_atencion", schema = "public")
public class Atencion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7664327493691156300L;

	@Id
	@Column(name = "codigo_interno", nullable = false)
	private Integer codigoInterno;
	
	@Column(name = "fechac")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	@Column(name = "activo_atencion")
	private Boolean estadoAtencion;

	public Atencion() {
		
	}

	public Integer getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(Integer codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Boolean getEstadoAtencion() {
		return estadoAtencion;
	}

	public void setEstadoAtencion(Boolean estadoAtencion) {
		this.estadoAtencion = estadoAtencion;
	}
}
