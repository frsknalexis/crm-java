package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class DetalleCuentaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6169921513032046311L;

	private String documentoPersonaCliente;
	
	private String observacionDetalleCuenta;
	
	private String codigoUsuario;
	
	private Date fechaSolicitudClienteDetalleCuenta;
	
	private String nombreVendedor;

	public DetalleCuentaRequest() {
		
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getObservacionDetalleCuenta() {
		return observacionDetalleCuenta;
	}

	public void setObservacionDetalleCuenta(String observacionDetalleCuenta) {
		this.observacionDetalleCuenta = observacionDetalleCuenta;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Date getFechaSolicitudClienteDetalleCuenta() {
		return fechaSolicitudClienteDetalleCuenta;
	}

	public void setFechaSolicitudClienteDetalleCuenta(Date fechaSolicitudClienteDetalleCuenta) {
		this.fechaSolicitudClienteDetalleCuenta = fechaSolicitudClienteDetalleCuenta;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}
}
