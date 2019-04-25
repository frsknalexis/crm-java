package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_in_servicio", schema = "public")
public class InternetServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4626589759100362958L;

	@Id
	@Column(name = "codi_serin", nullable=false)
	private BigDecimal codigoInternetServicio;
	
	@Column(name="fechainicio_serin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicioInternetServicio;
	
	@Column(name="fechatermino_serin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaTerminoInternetServicio;
	
	@Column(name="observacion_serin")
	private String ObservacionInternetServicio;
	
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
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="internetServicio")
	private List<InternetServicioDetalle> internetServiciosDetalles;

	public InternetServicio() {
		internetServiciosDetalles = new ArrayList<InternetServicioDetalle>();
	}

	public BigDecimal getCodigoInternetServicio() {
		return codigoInternetServicio;
	}

	public void setCodigoInternetServicio(BigDecimal codigoInternetServicio) {
		this.codigoInternetServicio = codigoInternetServicio;
	}

	public Date getFechaInicioInternetServicio() {
		return fechaInicioInternetServicio;
	}

	public void setFechaInicioInternetServicio(Date fechaInicioInternetServicio) {
		this.fechaInicioInternetServicio = fechaInicioInternetServicio;
	}

	public Date getFechaTerminoInternetServicio() {
		return fechaTerminoInternetServicio;
	}

	public void setFechaTerminoInternetServicio(Date fechaTerminoInternetServicio) {
		this.fechaTerminoInternetServicio = fechaTerminoInternetServicio;
	}

	public String getObservacionInternetServicio() {
		return ObservacionInternetServicio;
	}

	public void setObservacionInternetServicio(String observacionInternetServicio) {
		ObservacionInternetServicio = observacionInternetServicio;
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

	public List<InternetServicioDetalle> getInternetServiciosDetalles() {
		return internetServiciosDetalles;
	}

	public void setInternetServiciosDetalles(List<InternetServicioDetalle> internetServiciosDetalles) {
		this.internetServiciosDetalles = internetServiciosDetalles;
	}
}
