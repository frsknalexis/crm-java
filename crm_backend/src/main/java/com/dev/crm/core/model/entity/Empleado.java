package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_ci_empleado", schema="public")
@IdClass(value=EmpleadoPK.class)
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5930630574068721114L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_empleado", nullable=false, unique=true)
	private BigDecimal codigoEmpleado;
	
	@Id
	@Column(name="documento_personae", nullable=false, length=11)
	private String documentoPersonaEmpleado;
	
	@Column(name="activo_empleado")
	private Boolean estado;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codi_cargo", nullable=false)
	private Cargo cargo;

	public Empleado() {
		
	}

	public BigDecimal getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(BigDecimal codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getDocumentoPersonaEmpleado() {
		return documentoPersonaEmpleado;
	}

	public void setDocumentoPersonaEmpleado(String documentoPersonaEmpleado) {
		this.documentoPersonaEmpleado = documentoPersonaEmpleado;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
