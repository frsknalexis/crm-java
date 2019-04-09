package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="tb_ci_cliente", schema="public")
@IdClass(value=ClientePK.class)
@NamedStoredProcedureQuery(name="insertarCliente", procedureName="sp_inserccion_cliente", parameters= {
		@StoredProcedureParameter(mode=ParameterMode.IN, name="COD_DOC", type=String.class)
})
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6161632597950975614L;
	
	@Id
	@Column(name="cons_cliente", nullable=false)
	private Integer consecutivoCliente;
	
	@Id
	@Column(name="documento_personac", length=11, nullable=false)
	private String documentoPersonaCliente;
	
	@Column(name="codigo_cliente", length=6)
	private String codigoCliente;
	
	@Column(name="nombrecom_cliente")
	private String nombreComercialCliente;
	
	@Column(name="activo_cliente")
	private Boolean estado;
	
	@Column(name="correo_cliente")
	private String correoCliente;
	
	@Column(name="facebook_cliente")
	private String facebookCliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_sexo", nullable=false)
	private Sexo sexo;

	public Cliente() {
		
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNombreComercialCliente() {
		return nombreComercialCliente;
	}

	public void setNombreComercialCliente(String nombreComercialCliente) {
		this.nombreComercialCliente = nombreComercialCliente;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getFacebookCliente() {
		return facebookCliente;
	}

	public void setFacebookCliente(String facebookCliente) {
		this.facebookCliente = facebookCliente;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
}
