package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ci_respuesta_herramienta", schema = "public")
public class RespuestaHerramienta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9173557057022761837L;

	@Id
	@Column(name = "codrpt_herra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoRespuestaHerramienta;
	
	@Column(name = "documento_personac")
	private String documentoPersonaCliente;
	
	@Column(name = "cod_herra")
	private Integer codigoHerramienta;
	
	@Column(name = "valor_valor")
	private Integer valor;

	public RespuestaHerramienta() {
		
	}

	public Integer getCodigoRespuestaHerramienta() {
		return codigoRespuestaHerramienta;
	}

	public void setCodigoRespuestaHerramienta(Integer codigoRespuestaHerramienta) {
		this.codigoRespuestaHerramienta = codigoRespuestaHerramienta;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public Integer getCodigoHerramienta() {
		return codigoHerramienta;
	}

	public void setCodigoHerramienta(Integer codigoHerramienta) {
		this.codigoHerramienta = codigoHerramienta;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
}
