package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.dev.crm.core.model.base.AuditingEntity;
import com.dev.crm.core.model.base.BaseEntity;

@Entity
@Table(name="tb_ci_persona", schema="public")
@NamedStoredProcedureQuery(name="listaPersonasNoClientes", procedureName="sp_lista_persona_no_cliente", resultClasses=Persona.class,
        parameters= {
        		@StoredProcedureParameter(mode=ParameterMode.IN, name="COD_USU", type=String.class)
})
public class Persona extends AuditingEntity implements Serializable, BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8228410291800045232L;

	@Id
	@Column(name="documento_persona", length=11, nullable=false, unique=true)
	private String documentoPersona;
	
	@Column(name="nombre_persona", length=100, nullable=false)
	private String nombrePersona;
	
	@Column(name="apellidop_persona", length=20, nullable=false)
	private String apellidoPaternoPersona;
	
	@Column(name="apellidom_persona", length=20, nullable=false)
	private String apellidoMaternoPersona;
	
	@Column(name="direcciónr_persona", length=255)
	private String direccionReniecPersona;
	
	@Column(name="direccióna_persona", length=255)
	private String direccionActualPersona;
	
	@Column(name="referencia_persona", length=255)
	private String referenciaPersona;
	
	@Column(name="telefonou_persona", length=9)
	private String telefonoUnoPersona;
	
	@Column(name="telefonod_persona", length=9)
	private String telefonoDosPersona;
	
	@Column(name="telefonot_persona", length=9)
	private String telefonoTresPersona;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_ubigeo", nullable=false)
	private Ubigeo ubigeo;

	public Persona() {
		
	}

	public String getDocumentoPersona() {
		return documentoPersona;
	}

	public void setDocumentoPersona(String documentoPersona) {
		this.documentoPersona = documentoPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApellidoPaternoPersona() {
		return apellidoPaternoPersona;
	}

	public void setApellidoPaternoPersona(String apellidoPaternoPersona) {
		this.apellidoPaternoPersona = apellidoPaternoPersona;
	}

	public String getApellidoMaternoPersona() {
		return apellidoMaternoPersona;
	}

	public void setApellidoMaternoPersona(String apellidoMaternoPersona) {
		this.apellidoMaternoPersona = apellidoMaternoPersona;
	}

	public String getDireccionReniecPersona() {
		return direccionReniecPersona;
	}

	public void setDireccionReniecPersona(String direccionReniecPersona) {
		this.direccionReniecPersona = direccionReniecPersona;
	}

	public String getDireccionActualPersona() {
		return direccionActualPersona;
	}

	public void setDireccionActualPersona(String direccionActualPersona) {
		this.direccionActualPersona = direccionActualPersona;
	}

	public String getReferenciaPersona() {
		return referenciaPersona;
	}

	public void setReferenciaPersona(String referenciaPersona) {
		this.referenciaPersona = referenciaPersona;
	}

	public String getTelefonoUnoPersona() {
		return telefonoUnoPersona;
	}

	public void setTelefonoUnoPersona(String telefonoUnoPersona) {
		this.telefonoUnoPersona = telefonoUnoPersona;
	}

	public String getTelefonoDosPersona() {
		return telefonoDosPersona;
	}

	public void setTelefonoDosPersona(String telefonoDosPersona) {
		this.telefonoDosPersona = telefonoDosPersona;
	}

	public String getTelefonoTresPersona() {
		return telefonoTresPersona;
	}

	public void setTelefonoTresPersona(String telefonoTresPersona) {
		this.telefonoTresPersona = telefonoTresPersona;
	}

	public Ubigeo getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}
}
