package com.dev.crm.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	@Column(name = "cant_pago")
	private Double cantidadPago;
	
	@Column(name = "tipo_servicio")
	private String tipoServicio;

	public DetallePago() {
		
	}

	public Integer getCodigoDetallePago() {
		return codigoDetallePago;
	}

	public void setCodigoDetallePago(Integer codigoDetallePago) {
		this.codigoDetallePago = codigoDetallePago;
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
}
