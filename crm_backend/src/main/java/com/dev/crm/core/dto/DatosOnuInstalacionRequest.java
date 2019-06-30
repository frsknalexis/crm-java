package com.dev.crm.core.dto;

import java.io.Serializable;

public class DatosOnuInstalacionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8212162408955621815L;

	private Integer codigoDetalleCuenta;
	
	private String documentoPersonaCliente;
	
	private String serieOnu;
	
	private String macOnu;
	
	public DatosOnuInstalacionRequest() {
		
	}

	public Integer getCodigoDetalleCuenta() {
		return codigoDetalleCuenta;
	}

	public void setCodigoDetalleCuenta(Integer codigoDetalleCuenta) {
		this.codigoDetalleCuenta = codigoDetalleCuenta;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getSerieOnu() {
		return serieOnu;
	}

	public void setSerieOnu(String serieOnu) {
		this.serieOnu = serieOnu;
	}

	public String getMacOnu() {
		return macOnu;
	}

	public void setMacOnu(String macOnu) {
		this.macOnu = macOnu;
	}
}
