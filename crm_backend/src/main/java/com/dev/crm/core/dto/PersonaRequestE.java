package com.dev.crm.core.dto;

import java.io.Serializable;

public class PersonaRequestE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963154295950006311L;
	
	private String documentopersoma;
	
	private String nombrepersona;
	
	private String paternopersona;
	
	private String maternopersona;
	
	private String direccionreniecpersona;
	
	private String direccionactualpersona;
	
	private String referenciapersona;
	
	private String primertelefono;
	
	private String segundotelefono;
	
	private String tercertelefono;
	
	private String modificadopor;
	
	private String codigoubigeo;
	
	private String ipMaquina;
	
	private String usuarioMaquina;
	
	private String usuarioSistema;

	public PersonaRequestE() {
	
	}

	public String getDocumentopersoma() {
		return documentopersoma;
	}

	public void setDocumentopersoma(String documentopersoma) {
		this.documentopersoma = documentopersoma;
	}

	public String getNombrepersona() {
		return nombrepersona;
	}

	public void setNombrepersona(String nombrepersona) {
		this.nombrepersona = nombrepersona;
	}

	public String getPaternopersona() {
		return paternopersona;
	}

	public void setPaternopersona(String paternopersona) {
		this.paternopersona = paternopersona;
	}

	public String getMaternopersona() {
		return maternopersona;
	}

	public void setMaternopersona(String maternopersona) {
		this.maternopersona = maternopersona;
	}

	public String getDireccionreniecpersona() {
		return direccionreniecpersona;
	}

	public void setDireccionreniecpersona(String direccionreniecpersona) {
		this.direccionreniecpersona = direccionreniecpersona;
	}

	public String getDireccionactualpersona() {
		return direccionactualpersona;
	}

	public void setDireccionactualpersona(String direccionactualpersona) {
		this.direccionactualpersona = direccionactualpersona;
	}

	public String getReferenciapersona() {
		return referenciapersona;
	}

	public void setReferenciapersona(String referenciapersona) {
		this.referenciapersona = referenciapersona;
	}

	public String getPrimertelefono() {
		return primertelefono;
	}

	public void setPrimertelefono(String primertelefono) {
		this.primertelefono = primertelefono;
	}

	public String getSegundotelefono() {
		return segundotelefono;
	}

	public void setSegundotelefono(String segundotelefono) {
		this.segundotelefono = segundotelefono;
	}

	public String getTercertelefono() {
		return tercertelefono;
	}

	public void setTercertelefono(String tercertelefono) {
		this.tercertelefono = tercertelefono;
	}

	public String getModificadopor() {
		return modificadopor;
	}

	public void setModificadopor(String modificadopor) {
		this.modificadopor = modificadopor;
	}

	public String getCodigoubigeo() {
		return codigoubigeo;
	}

	public void setCodigoubigeo(String codigoubigeo) {
		this.codigoubigeo = codigoubigeo;
	}

	public String getIpMaquina() {
		return ipMaquina;
	}

	public void setIpMaquina(String ipMaquina) {
		this.ipMaquina = ipMaquina;
	}

	public String getUsuarioMaquina() {
		return usuarioMaquina;
	}

	public void setUsuarioMaquina(String usuarioMaquina) {
		this.usuarioMaquina = usuarioMaquina;
	}

	public String getUsuarioSistema() {
		return usuarioSistema;
	}

	public void setUsuarioSistema(String usuarioSistema) {
		this.usuarioSistema = usuarioSistema;
	}
}
