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
@Table(name = "tb_ci_valor", schema = "public")
public class Valor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3472156209067653190L;

	@Id
	@Column(name = "codi_valo", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal codigoValor;
	
	@Column(name = "valo_valo")
	private String valor;

	public Valor() {
	
	}

	public BigDecimal getCodigoValor() {
		return codigoValor;
	}

	public void setCodigoValor(BigDecimal codigoValor) {
		this.codigoValor = codigoValor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	} 
}
