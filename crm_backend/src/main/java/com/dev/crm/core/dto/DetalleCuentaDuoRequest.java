package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class DetalleCuentaDuoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6985303945482974831L;

	private String documentoPersonCliente;
	
	private String observacionDetalleCuenta;
	
	private String codigoUsuario;
	
	private Date fechaSolicitudClienteDetalleCuenta;
	
	private String nombreVendedor;

	public DetalleCuentaDuoRequest() {
		
	}

	public String getDocumentoPersonCliente() {
		return documentoPersonCliente;
	}

	public void setDocumentoPersonCliente(String documentoPersonCliente) {
		this.documentoPersonCliente = documentoPersonCliente;
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
