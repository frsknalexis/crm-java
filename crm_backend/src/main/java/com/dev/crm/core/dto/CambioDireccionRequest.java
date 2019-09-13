package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class CambioDireccionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;

	private String documentoPersonaCliente;
	
	private String nuevaDireccion;
	
	private String observacionCuenta;
	
	private Date fechaElegida;
	
	private String vendedorResponsable;

	public CambioDireccionRequest() {
		
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
	}

	public String getNuevaDireccion() {
		return nuevaDireccion;
	}

	public void setNuevaDireccion(String nuevaDireccion) {
		this.nuevaDireccion = nuevaDireccion;
	}

	public String getObservacionCuenta() {
		return observacionCuenta;
	}

	public void setObservacionCuenta(String observacionCuenta) {
		this.observacionCuenta = observacionCuenta;
	}

	public Date getFechaElegida() {
		return fechaElegida;
	}

	public void setFechaElegida(Date fechaElegida) {
		this.fechaElegida = fechaElegida;
	}

	public String getVendedorResponsable() {
		return vendedorResponsable;
	}

	public void setVendedorResponsable(String vendedorResponsable) {
		this.vendedorResponsable = vendedorResponsable;
	}
}
