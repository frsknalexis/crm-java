package com.dev.crm.core.dto;

import java.io.Serializable;

public class PersonaDTO extends AuditingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5810637233602282364L;

	private String documentoPersona;
	
	private String nombrePersona;
	
	private String apellidoPaternoPersona;
	
	private String apellidoMaternoPersona;
	
	private String direccionReniecPersona;
	
	private String direccionActualPersona;
	
	private String referenciaPersona;
	
	private String telefonoUnoPersona;
	
	private String telefonoDosPersona;
	
	private String telefonoTresPersona;
	
	private UbigeoDTO ubigeo;

	public PersonaDTO() {
		
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

	public UbigeoDTO getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(UbigeoDTO ubigeo) {
		this.ubigeo = ubigeo;
	}
}
