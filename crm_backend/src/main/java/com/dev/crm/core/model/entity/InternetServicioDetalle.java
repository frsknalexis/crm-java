package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_inse_det", schema = "public")
public class InternetServicioDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 171301919236794939L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codi_insedet", nullable=false, unique=true)
	private BigDecimal codigoInternetServicioDetalle;
	
	@Column(name="cantidadmate_detin")
	private Integer cantidadMaterialDetalleInternet;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codi_serin")
	private InternetServicio internetServicio;

	public InternetServicioDetalle() {
		
	}

	public BigDecimal getCodigoInternetServicioDetalle() {
		return codigoInternetServicioDetalle;
	}

	public void setCodigoInternetServicioDetalle(BigDecimal codigoInternetServicioDetalle) {
		this.codigoInternetServicioDetalle = codigoInternetServicioDetalle;
	}

	public Integer getCantidadMaterialDetalleInternet() {
		return cantidadMaterialDetalleInternet;
	}

	public void setCantidadMaterialDetalleInternet(Integer cantidadMaterialDetalleInternet) {
		this.cantidadMaterialDetalleInternet = cantidadMaterialDetalleInternet;
	}

	public InternetServicio getInternetServicio() {
		return internetServicio;
	}

	public void setInternetServicio(InternetServicio internetServicio) {
		this.internetServicio = internetServicio;
	}
}
