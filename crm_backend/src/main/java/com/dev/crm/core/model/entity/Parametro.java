package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_ci_parametro", schema = "public")
@IdClass(value=ParametroPK.class)
public class Parametro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1011974310530582956L;

	@Id
	@Column(name="codi_parametro", nullable=false, length=4)
	private String codigoParametro;
	
	@Id
	@Column(name="nombre_empresa", nullable=false, length=200)
	private String nombreEmpresa;
	
	@Column(name="porcentaje_bobo", nullable=false)
	private Double porcentajeBono;
	
	@Column(name="atencion_dia", nullable=false)
	private Integer atencionDia;
	
	@Column(name="valor_uit")
	private Double valorUIT;
	
	@Column(name="dia_atencion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date diaAtencion;

	public Parametro() {
		
	}

	public String getCodigoParametro() {
		return codigoParametro;
	}

	public void setCodigoParametro(String codigoParametro) {
		this.codigoParametro = codigoParametro;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Double getPorcentajeBono() {
		return porcentajeBono;
	}

	public void setPorcentajeBono(Double porcentajeBono) {
		this.porcentajeBono = porcentajeBono;
	}

	public Integer getAtencionDia() {
		return atencionDia;
	}

	public void setAtencionDia(Integer atencionDia) {
		this.atencionDia = atencionDia;
	}

	public Double getValorUIT() {
		return valorUIT;
	}

	public void setValorUIT(Double valorUIT) {
		this.valorUIT = valorUIT;
	}

	public Date getDiaAtencion() {
		return diaAtencion;
	}

	public void setDiaAtencion(Date diaAtencion) {
		this.diaAtencion = diaAtencion;
	}
}
