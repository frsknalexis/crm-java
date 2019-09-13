package com.dev.crm.core.dto;

import java.io.Serializable;

public class DatosOnuInstalacionResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -192569864502908955L;

	
	private String macDescripcion;
	
	private String snDescripcion;
	
	private String winUser;
	
	private String winPassword;
	
	private String ponDescripcion;

	public DatosOnuInstalacionResultViewModel() {
		
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

	public String getPonDescripcion() {
		return ponDescripcion;
	}

	public void setPonDescripcion(String ponDescripcion) {
		this.ponDescripcion = ponDescripcion;
	}
}