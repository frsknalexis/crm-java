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
@Table(name="tb_ci_sexo", schema="public")
public class Sexo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1570203395317984109L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_sexo", nullable=false, unique=true)
	private BigDecimal codigoSexo;
	
	@Column(name="descripcion_sexo", length=9, nullable=false)
	private String descripcionSexo;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="sexo")
	private List<Cliente> clientes;

	public Sexo() {
		clientes = new ArrayList<Cliente>();
	}

	public BigDecimal getCodigoSexo() {
		return codigoSexo;
	}

	public void setCodigoSexo(BigDecimal codigoSexo) {
		this.codigoSexo = codigoSexo;
	}

	public String getDescripcionSexo() {
		return descripcionSexo;
	}

	public void setDescripcionSexo(String descripcionSexo) {
		this.descripcionSexo = descripcionSexo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
