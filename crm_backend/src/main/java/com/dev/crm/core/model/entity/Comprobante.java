package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ci_comprobante", schema = "public")
public class Comprobante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8528141162378602333L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_comprobante", nullable=false, unique=true)
	private BigDecimal codigoComprobante;
	
	@Column(name="descripcion_comprobante", nullable=false)
	private String descripcionComprobante;
	
	public Comprobante() {
	
	}

	public BigDecimal getCodigoComprobante() {
		return codigoComprobante;
	}

	public void setCodigoComprobante(BigDecimal codigoComprobante) {
		this.codigoComprobante = codigoComprobante;
	}

	public String getDescripcionComprobante() {
		return descripcionComprobante;
	}

	public void setDescripcionComprobante(String descripcionComprobante) {
		this.descripcionComprobante = descripcionComprobante;
	}
}
