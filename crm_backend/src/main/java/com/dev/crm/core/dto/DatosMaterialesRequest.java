package com.dev.crm.core.dto;

import java.io.Serializable;

public class DatosMaterialesRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1144884810776479716L;

	private String nombreMaterial;
	
	private Integer cantidadMaterial;
	
	private Integer codigoInternetServicio;

	public DatosMaterialesRequest() {
		
	}

	public String getNombreMaterial() {
		return nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public Integer getCantidadMaterial() {
		return cantidadMaterial;
	}

	public void setCantidadMaterial(Integer cantidadMaterial) {
		this.cantidadMaterial = cantidadMaterial;
	}

	public Integer getCodigoInternetServicio() {
		return codigoInternetServicio;
	}

	public void setCodigoInternetServicio(Integer codigoInternetServicio) {
		this.codigoInternetServicio = codigoInternetServicio;
	}
}
