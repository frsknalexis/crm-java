package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_ci_detalleher", schema = "public")
@IdClass(value = DetalleHerramientaPK.class)
public class DetalleHerramienta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7116319733823685087L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codi_dether")
	private Integer codigoDetalleHerramienta;
	
	@Id
	@Column(name = "codi_herra")
	private Integer codigoHerramienta;
	
	@Id
	@Column(name = "fechae_herra")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistroHerramienta;
	
	@Id
	@Column(name = "sec_herra")
	private Integer secuencialHerramienta;
	
	@Column(name = "pregunta")
	private String pregunta;

	public DetalleHerramienta() {
		
	}

	public Integer getCodigoDetalleHerramienta() {
		return codigoDetalleHerramienta;
	}

	public void setCodigoDetalleHerramienta(Integer codigoDetalleHerramienta) {
		this.codigoDetalleHerramienta = codigoDetalleHerramienta;
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

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
}
