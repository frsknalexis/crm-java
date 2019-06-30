package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ci_cuenta", schema = "public")
@IdClass(value=CuentaPK.class)
public class Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4707184631631369701L;

	@Id
	@Column(name="documento_personac", nullable=false, length=11)
	private String documentoPersonaCliente;
	
	@Id
	@Column(name="codi_cuenta", nullable = false)
	private Integer codigoCuenta;
	
	@Id
	@Column(name="codi_anio", nullable=false, length=4)
	private String codigoAnio;
	
	@Id
	@Column(name="cons_cliente", nullable=false)
	private Integer consecutivoCliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_externo")
	private EmpleadoExterno empleadoExterno;

	public Cuenta() {
		
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}
	
	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}
	
	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getCodigoAnio() {
		return codigoAnio;
	}

	public void setCodigoAnio(String codigoAnio) {
		this.codigoAnio = codigoAnio;
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
	}

	public EmpleadoExterno getEmpleadoExterno() {
		return empleadoExterno;
	}

	public void setEmpleadoExterno(EmpleadoExterno empleadoExterno) {
		this.empleadoExterno = empleadoExterno;
	}
}
