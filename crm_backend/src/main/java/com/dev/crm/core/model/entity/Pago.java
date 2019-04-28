package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_ci_pago", schema = "public")
@IdClass(value=PagoPK.class)
public class Pago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7429589596027510641L;

	@Id
	@Column(name = "codigo_pago", nullable=false, length=10)
	private String codigoPago;
	
	@Id
	@Column(name = "tipo_servicio", nullable=false)
	private String tipoServicio;
	
	@Id
	@Column(name = "serie_pago", nullable=false)
	private Integer seriePago;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_comprobante")
	private Comprobante comprobante;
	
	@Column(name = "fecha_pago")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPago;
	
	@Column(name = "descuento")
	private Double descuento;
	
	@Column(name = "ippc_pago")
	private String ipPcPago;
	
	@Column(name = "nombreu_pago")
	private String nombreUsuarioPago;
	
	@Column(name = "nombres_pago")
	private String nombreUsuarioMaquinaPago;
	
	@Column(name = "documentoc_persona")
	private String documentoPersonaPago;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codigo_interno")
	private EmpleadoInterno empleadoInterno;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Cliente cliente;
	
	@Column(name = "totapago")
	private Double totalPago;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="pago")
	private List<DetallePago> detallesPago;

	public Pago() {
		detallesPago = new ArrayList<DetallePago>();
	}

	public String getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(String codigoPago) {
		this.codigoPago = codigoPago;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Integer getSeriePago() {
		return seriePago;
	}

	public void setSeriePago(Integer seriePago) {
		this.seriePago = seriePago;
	}

	public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public String getIpPcPago() {
		return ipPcPago;
	}

	public void setIpPcPago(String ipPcPago) {
		this.ipPcPago = ipPcPago;
	}

	public String getNombreUsuarioPago() {
		return nombreUsuarioPago;
	}

	public void setNombreUsuarioPago(String nombreUsuarioPago) {
		this.nombreUsuarioPago = nombreUsuarioPago;
	}

	public String getNombreUsuarioMaquinaPago() {
		return nombreUsuarioMaquinaPago;
	}

	public void setNombreUsuarioMaquinaPago(String nombreUsuarioMaquinaPago) {
		this.nombreUsuarioMaquinaPago = nombreUsuarioMaquinaPago;
	}

	public String getDocumentoPersonaPago() {
		return documentoPersonaPago;
	}

	public void setDocumentoPersonaPago(String documentoPersonaPago) {
		this.documentoPersonaPago = documentoPersonaPago;
	}

	public EmpleadoInterno getEmpleadoInterno() {
		return empleadoInterno;
	}

	public void setEmpleadoInterno(EmpleadoInterno empleadoInterno) {
		this.empleadoInterno = empleadoInterno;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(Double totalPago) {
		this.totalPago = totalPago;
	}

	public List<DetallePago> getDetallesPago() {
		return detallesPago;
	}

	public void setDetallesPago(List<DetallePago> detallesPago) {
		this.detallesPago = detallesPago;
	}
}
