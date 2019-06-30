package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class CuentasPorInstalarResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9161690073009567669L;

	private Integer codigoDetalleCuenta;
	
	private Integer codigoCuenta;
	
	private String documentoPersonaCliente;
	
	private String cliente;
	
	private String direccionActualCliente;
	
	private Date fechaProgramacionInstalacion;

	public CuentasPorInstalarResultViewModel() {
		
	}

	public Integer getCodigoDetalleCuenta() {
		return codigoDetalleCuenta;
	}

	public void setCodigoDetalleCuenta(Integer codigoDetalleCuenta) {
		this.codigoDetalleCuenta = codigoDetalleCuenta;
	}

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
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

	public Date getFechaProgramacionInstalacion() {
		return fechaProgramacionInstalacion;
	}

	public void setFechaProgramacionInstalacion(Date fechaProgramacionInstalacion) {
		this.fechaProgramacionInstalacion = fechaProgramacionInstalacion;
	}
}
