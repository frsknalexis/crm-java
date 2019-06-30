package com.dev.crm.core.dto;

import java.io.Serializable;

public class DatosOnusResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -192569864502908955L;

	
	private String macDescripcion;
	
	private String snDescripcion;
	
	private String winUser;
	
	private String winPassword;
	
	private String wifissidDescripcion;
	
	private String wifiPasswordDescripcion;
	
	private String estado;

	public DatosOnusResultViewModel() {
		
	}

	public String getMacDescripcion() {
		return macDescripcion;
	}

	public void setMacDescripcion(String macDescripcion) {
		this.macDescripcion = macDescripcion;
	}

	public String getSnDescripcion() {
		return snDescripcion;
	}

	public void setSnDescripcion(String snDescripcion) {
		this.snDescripcion = snDescripcion;
	}

	public String getWinUser() {
		return winUser;
	}

	public void setWinUser(String winUser) {
		this.winUser = winUser;
	}

	public String getWinPassword() {
		return winPassword;
	}

	public void setWinPassword(String winPassword) {
		this.winPassword = winPassword;
	}

	public String getWifissidDescripcion() {
		return wifissidDescripcion;
	}

	public void setWifissidDescripcion(String wifissidDescripcion) {
		this.wifissidDescripcion = wifissidDescripcion;
	}

	public String getWifiPasswordDescripcion() {
		return wifiPasswordDescripcion;
	}

	public void setWifiPasswordDescripcion(String wifiPasswordDescripcion) {
		this.wifiPasswordDescripcion = wifiPasswordDescripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
