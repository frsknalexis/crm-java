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
@Table(name = "tb_ci_tipo_herramienta", schema = "public")
public class TipoHerramienta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2218892644283140544L;

	@Id
	@Column(name = "codi_tipherr", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal codigoTipoHerramienta;
	
	@Column(name = "descripcion_tipherr", nullable = false)
	private String descripcionTipoHerramienta;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tipoHerramienta")
	private List<Herramienta> herramientas;
	
	public TipoHerramienta() {
		herramientas = new ArrayList<Herramienta>();
	}

	public BigDecimal getCodigoTipoHerramienta() {
		return codigoTipoHerramienta;
	}

	public void setCodigoTipoHerramienta(BigDecimal codigoTipoHerramienta) {
		this.codigoTipoHerramienta = codigoTipoHerramienta;
	}

	public String getDescripcionTipoHerramienta() {
		return descripcionTipoHerramienta;
	}

	public void setDescripcionTipoHerramienta(String descripcionTipoHerramienta) {
		this.descripcionTipoHerramienta = descripcionTipoHerramienta;
	}

	public List<Herramienta> getHerramientas() {
		return herramientas;
	}

	public void setHerramientas(List<Herramienta> herramientas) {
		this.herramientas = herramientas;
	}
}
