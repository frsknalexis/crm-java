package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_ci_detcun", schema = "public")
@IdClass(value=DetalleCuentaPK.class)
public class DetalleCuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -446064555740745195L;
	
	@Id
	@Column(name="tipo_servicio", nullable=false, length=2)
	private String tipoServicio;
	
	@Id
	@Column(name="documento_personac", nullable=false, length=12)
	private String documentoPersonaCliente;
	
	@Id
	@Column(name="codi_detcun", nullable=false)
	private Integer codigoDetalleCuenta;

	@Id
	@Column(name="codi_cuenta", nullable=false)
	private Integer codigoCuenta;
	
	@Id
	@Column(name="codi_anio", nullable=false)
	private String codigoAnio;
	
	@Id
	@Column(name="cons_cliente", nullable=false)
	private Integer consecutivoCliente;
	
	@Column(name="observacion_detcue")
	private String observacionDetalleCuenta;
	
	@Column(name="fechacan_detcue")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCancelacionDetalleCuenta;
	
	@Column(name="fechapro_detcue")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaProgramacionDetalleCuenta;
	
	@Column(name="fechar_detcue")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistroDetalleCuenta;
	
	@Column(name="est_detcun")
	private Integer estadoDetalleCuenta;
	
	@Column(name="fechacli_detcue")
	private Date fechaSolicitudClienteDetalleCuenta;
	
	@Column(name="codigoextervalue")
	private Integer codigoexterno;
	
	public DetalleCuenta() {
		
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
