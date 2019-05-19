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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ci_estado_recldet", schema = "public")
public class EstadoReclamoDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1164964688535524258L;

	@Id
	@Column(name = "codi_estado", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal codigoEstadoReclamoDetalle;
	
	@Column(name = "descripcion_estado")
	private String descripcionEstado;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "estadoReclamoDetalle")
	private List<Reclamo> reclamos;
	
	public EstadoReclamoDetalle() {
		reclamos = new ArrayList<Reclamo>();
	}

	public BigDecimal getCodigoEstadoReclamoDetalle() {
		return codigoEstadoReclamoDetalle;
	}

	public void setCodigoEstadoReclamoDetalle(BigDecimal codigoEstadoReclamoDetalle) {
		this.codigoEstadoReclamoDetalle = codigoEstadoReclamoDetalle;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}
}
