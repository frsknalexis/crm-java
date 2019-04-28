package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ci_detalle_pago", schema = "public")
public class DetallePago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1650248100746422138L;

	@Id
	@Column(name = "codi_detp", nullable=false)
	private Integer codigoDetallePago;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Pago pago;
	
	@Column(name = "cant_pago")
	private Double cantidadPago;
	
	@Column(name = "tipo_servicio")
	private String tipoServicio;
	
	@Column(name="mes_valido")
	private Integer mesValido;
	
	@Column(name="numero_caja")
	private String numeroCaja;
	
	@Column(name="anio_valido")
	private String anioValido;

	public DetallePago() {
		
	}

	public Integer getCodigoDetallePago() {
		return codigoDetallePago;
	}

	public void setCodigoDetallePago(Integer codigoDetallePago) {
		this.codigoDetallePago = codigoDetallePago;
	}
	
	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Double getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(Double cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Integer getMesValido() {
		return mesValido;
	}

	public void setMesValido(Integer mesValido) {
		this.mesValido = mesValido;
	}

	public String getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	public String getAnioValido() {
		return anioValido;
	}

	public void setAnioValido(String anioValido) {
		this.anioValido = anioValido;
	}
}
