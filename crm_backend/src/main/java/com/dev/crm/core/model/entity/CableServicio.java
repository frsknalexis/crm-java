package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_ca_servicio", schema = "public")
public class CableServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6282227956640262402L;

	@Id
	@Column(name="codi_serca", nullable=false)
	private BigDecimal codigoCableServicio;
	
	@Column(name="fechainicio_serca")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicioCableServicio;
	
	@Column(name="fechatermino_serca")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaTerminoCableServicio;
	
	@Column(name="observacion_serca")
	private String observacionCableServicio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codi_estado", nullable=false)
	private EstadoCuenta estadoCuenta;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codi_tipo_Serv", nullable=false)
	private Servicio servicio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Cliente cliente;
	
	@Column(name="codi_cuenta")
	private String codigoCuenta;
	
	@Column(name="codi_anio")
	private String codigoAnio;
	
	@Column(name="codi_detcun")
	private Integer codigoDetalleCuenta;

	@Column(name="cons_cliente")
	private Integer consecutivoCliente;
	
	@Column(name="descuento")
	private Double descuento;
	
	public CableServicio() {
		
	}

	public BigDecimal getCodigoCableServicio() {
		return codigoCableServicio;
	}

	public void setCodigoCableServicio(BigDecimal codigoCableServicio) {
		this.codigoCableServicio = codigoCableServicio;
	}

	public Date getFechaInicioCableServicio() {
		return fechaInicioCableServicio;
	}

	public void setFechaInicioCableServicio(Date fechaInicioCableServicio) {
		this.fechaInicioCableServicio = fechaInicioCableServicio;
	}

	public Date getFechaTerminoCableServicio() {
		return fechaTerminoCableServicio;
	}

	public void setFechaTerminoCableServicio(Date fechaTerminoCableServicio) {
		this.fechaTerminoCableServicio = fechaTerminoCableServicio;
	}

	public String getObservacionCableServicio() {
		return observacionCableServicio;
	}

	public void setObservacionCableServicio(String observacionCableServicio) {
		this.observacionCableServicio = observacionCableServicio;
	}

	public EstadoCuenta getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getCodigoAnio() {
		return codigoAnio;
	}

	public void setCodigoAnio(String codigoAnio) {
		this.codigoAnio = codigoAnio;
	}

	public Integer getCodigoDetalleCuenta() {
		return codigoDetalleCuenta;
	}

	public void setCodigoDetalleCuenta(Integer codigoDetalleCuenta) {
		this.codigoDetalleCuenta = codigoDetalleCuenta;
	}

	public Integer getConsecutivoCliente() {
		return consecutivoCliente;
	}

	public void setConsecutivoCliente(Integer consecutivoCliente) {
		this.consecutivoCliente = consecutivoCliente;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
}
