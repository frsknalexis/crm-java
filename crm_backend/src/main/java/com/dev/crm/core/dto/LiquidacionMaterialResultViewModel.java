package com.dev.crm.core.dto;

import java.io.Serializable;

public class LiquidacionMaterialResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2360822386661959196L;

	private String codigoServicioInternet;
	
	private String fechaInicio;
	
	private String observacion;
	
	private String documentoCliente;
	
	private String codigoMaterial;
	
	private String cantidadMaterial;
	
	private String descripcionMaterial;
	
	private String cliente;
	
	private String serieOnu;
	
	private String wifiUser;
	
	private String wifiPassword;
	
	private String tecnicoResponsable;
	
	private String direccionCliente;
	
	private String correoCliente;
	
	private String tipoOnu;
	
	private String potenciaOnu;
	
	public LiquidacionMaterialResultViewModel() {
		
	}

	public String getCodigoServicioInternet() {
		return codigoServicioInternet;
	}

	public void setCodigoServicioInternet(String codigoServicioInternet) {
		this.codigoServicioInternet = codigoServicioInternet;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getCodigoMaterial() {
		return codigoMaterial;
	}

	public void setCodigoMaterial(String codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	public String getCantidadMaterial() {
		return cantidadMaterial;
	}

	public void setCantidadMaterial(String cantidadMaterial) {
		this.cantidadMaterial = cantidadMaterial;
	}

	public String getDescripcionMaterial() {
		return descripcionMaterial;
	}

	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getSerieOnu() {
		return serieOnu;
	}

	public void setSerieOnu(String serieOnu) {
		this.serieOnu = serieOnu;
	}

	public String getWifiUser() {
		return wifiUser;
	}

	public void setWifiUser(String wifiUser) {
		this.wifiUser = wifiUser;
	}

	public String getWifiPassword() {
		return wifiPassword;
	}

	public void setWifiPassword(String wifiPassword) {
		this.wifiPassword = wifiPassword;
	}

	public String getTecnicoResponsable() {
		return tecnicoResponsable;
	}

	public void setTecnicoResponsable(String tecnicoResponsable) {
		this.tecnicoResponsable = tecnicoResponsable;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getTipoOnu() {
		return tipoOnu;
	}

	public void setTipoOnu(String tipoOnu) {
		this.tipoOnu = tipoOnu;
	}

	public String getPotenciaOnu() {
		return potenciaOnu;
	}

	public void setPotenciaOnu(String potenciaOnu) {
		this.potenciaOnu = potenciaOnu;
	}
}
