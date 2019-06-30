package com.dev.crm.core.dto;

import java.io.Serializable;
import java.util.Date;

public class DetalleCuentaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3719462393187736620L;

	private String  tipoServicio;
	
	private String documentoPersonaCliente;
	
	private Integer codigoDetalleCuenta;
	
	private Integer codigoCuenta;
	
	private String codigoAnio;
	
	private Integer consecutivoCliente;
	
	private String observacionDetalleCuenta;
	
	private Date fechaCancelacionDetalleCuenta;
	
	private Date fechaProgramacionDetalleCuenta;
	
	private Date fechaRegistroDetalleCuenta;
	
	private Integer estadoDetalleCuenta;
	
	private Date fechaSolicitudClienteDetalleCuenta;
	
	private Integer codigoexterno;
	
	public DetalleCuentaDTO() {
		
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getDocumentoPersonaCliente() {
		return documentoPersonaCliente;
	}

	public void setDocumentoPersonaCliente(String documentoPersonaCliente) {
		this.documentoPersonaCliente = documentoPersonaCliente;
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

	public String getCodigoAnio() {
		return codigoAnio;
	}

	public void setCodigoAnio(String codigoAnio) {
		this.codigoAnio = codigoAnio;
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
	}

	public String getObservacionDetalleCuenta() {
		return observacionDetalleCuenta;
	}

	public void setObservacionDetalleCuenta(String observacionDetalleCuenta) {
		this.observacionDetalleCuenta = observacionDetalleCuenta;
	}

	public Date getFechaCancelacionDetalleCuenta() {
		return fechaCancelacionDetalleCuenta;
	}

	public void setFechaCancelacionDetalleCuenta(Date fechaCancelacionDetalleCuenta) {
		this.fechaCancelacionDetalleCuenta = fechaCancelacionDetalleCuenta;
	}

	public Date getFechaProgramacionDetalleCuenta() {
		return fechaProgramacionDetalleCuenta;
	}

	public void setFechaProgramacionDetalleCuenta(Date fechaProgramacionDetalleCuenta) {
		this.fechaProgramacionDetalleCuenta = fechaProgramacionDetalleCuenta;
	}

	public Date getFechaRegistroDetalleCuenta() {
		return fechaRegistroDetalleCuenta;
	}

	public void setFechaRegistroDetalleCuenta(Date fechaRegistroDetalleCuenta) {
		this.fechaRegistroDetalleCuenta = fechaRegistroDetalleCuenta;
	}

	public Integer getEstadoDetalleCuenta() {
		return estadoDetalleCuenta;
	}

	public void setEstadoDetalleCuenta(Integer estadoDetalleCuenta) {
		this.estadoDetalleCuenta = estadoDetalleCuenta;
	}

	public Date getFechaSolicitudClienteDetalleCuenta() {
		return fechaSolicitudClienteDetalleCuenta;
	}

	public void setFechaSolicitudClienteDetalleCuenta(Date fechaSolicitudClienteDetalleCuenta) {
		this.fechaSolicitudClienteDetalleCuenta = fechaSolicitudClienteDetalleCuenta;
	}

	public Integer getCodigoexterno() {
		return codigoexterno;
	}

	public void setCodigoexterno(Integer codigoexterno) {
		this.codigoexterno = codigoexterno;
	}	
}
