package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class ClientePagoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -192569864502908955L;

	
	private String documentoPersonaCliente;
	
	private String nombreComercialCliente;
	
	private String cliente;
	
	private String direccionActualCliente;
	
	private String referencia;
	
	private Date fechaInstalacion;
	
	private String gestorResponsable;
	
	private String telefonoGestor;
	
	private Date fechaInstalacionCable;
	
	private String codigoClienteCable;

	public ClientePagoResultViewModel() {
		
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getNombreComercialCliente() {
		return nombreComercialCliente;
	}

	public void setNombreComercialCliente(String nombreComercialCliente) {
		this.nombreComercialCliente = nombreComercialCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccionActualCliente() {
		return direccionActualCliente;
	}

	public void setDireccionActualCliente(String direccionActualCliente) {
		this.direccionActualCliente = direccionActualCliente;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}

	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}

	public String getGestorResponsable() {
		return gestorResponsable;
	}

	public void setGestorResponsable(String gestorResponsable) {
		this.gestorResponsable = gestorResponsable;
	}

	public String getTelefonoGestor() {
		return telefonoGestor;
	}

	public void setTelefonoGestor(String telefonoGestor) {
		this.telefonoGestor = telefonoGestor;
	}

	public Date getFechaInstalacionCable() {
		return fechaInstalacionCable;
	}

	public void setFechaInstalacionCable(Date fechaInstalacionCable) {
		this.fechaInstalacionCable = fechaInstalacionCable;
	}

	public String getCodigoClienteCable() {
		return codigoClienteCable;
	}

	public void setCodigoClienteCable(String codigoClienteCable) {
		this.codigoClienteCable = codigoClienteCable;
	}
}
