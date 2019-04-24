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
@Table(name = "tb_ci_estado", schema = "public")
public class EstadoCuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8990830208453464854L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codi_estado", nullable=false, unique=true)
	private BigDecimal codigoEstado;
	
	@Column(name="descripcion_estado", nullable=false)
	private String descripcionEstado;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="estadoCuenta")
	private List<CableServicio> cablesServicios;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="estadoCuenta")
	private List<InternetServicio> internetServicios;

	public EstadoCuenta() {
		cablesServicios = new ArrayList<CableServicio>();
		internetServicios = new ArrayList<InternetServicio>();
	}

	public BigDecimal getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(BigDecimal codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public List<CableServicio> getCablesServicios() {
		return cablesServicios;
	}

	public void setCablesServicios(List<CableServicio> cablesServicios) {
		this.cablesServicios = cablesServicios;
	}

	public List<InternetServicio> getInternetServicios() {
		return internetServicios;
	}

	public void setInternetServicios(List<InternetServicio> internetServicios) {
		this.internetServicios = internetServicios;
	}
}
