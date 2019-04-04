package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AuditingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9167908165727307076L;
	
	private Boolean habilitado;
	
	private BigDecimal creadoPor;
	
	private BigDecimal modificadoPor;
	
	private Date fechaRegistro;
	
	private Date fechaModificacion;
	
	private Date fechaActivacion;
	
	private Date fechaDesactivacion;

	public AuditingDTO() {
		
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public BigDecimal getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(BigDecimal creadoPor) {
		this.creadoPor = creadoPor;
	}

	public BigDecimal getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(BigDecimal modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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
}
