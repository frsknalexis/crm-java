package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ci_pre_ser", schema = "public")
public class Servicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7109553943864228504L;
	
	@Id
	@Column(name="codi_tipo_Serv", nullable=false)
	private String codigoServicio;

	@Column(name="descripcion_tipo_servicio", nullable=false)
	private String descripcionTipoServicio;
	
	@Column(name="precio_tipo_servicio", nullable=false)
	private Double precioServicio;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="servicio")
	private List<CableServicio> cablesServicios;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="servicio")
	private List<InternetServicio> internetServicios;

	public Servicio() {
		cablesServicios = new ArrayList<CableServicio>();
		internetServicios= new ArrayList<InternetServicio>();
	}

	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getDescripcionTipoServicio() {
		return descripcionTipoServicio;
	}

	public void setDescripcionTipoServicio(String descripcionTipoServicio) {
		this.descripcionTipoServicio = descripcionTipoServicio;
	}

	public Double getPrecioServicio() {
		return precioServicio;
	}

	public void setPrecioServicio(Double precioServicio) {
		this.precioServicio = precioServicio;
	}

	public List<CableServicio> getCablesServicios() {
		return cablesServicios;
	}

	public void setCablesServicios(List<CableServicio> cablesServicios) {
		this.cablesServicios = cablesServicios;
	}

	public List<InternetServicio> getInternetServicios() {
		return internetServicios;
	}

	public void setInternetServicios(List<InternetServicio> internetServicios) {
		this.internetServicios = internetServicios;
	}
}
