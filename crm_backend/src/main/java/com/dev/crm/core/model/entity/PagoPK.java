package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class PagoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7211120553129555600L;

	private String codigoPago;
	
	private String tipoServicio;
	
	private Integer seriePago;

	public PagoPK() {
		
	}

	public PagoPK(String codigoPago, String tipoServicio, Integer seriePago) {
		super();
		this.codigoPago = codigoPago;
		this.tipoServicio = tipoServicio;
		this.seriePago = seriePago;
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

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		final PagoPK other = (PagoPK) obj;
		if(!Objects.equals(this.codigoPago, other.codigoPago)) {
			return false;
		}
		if(!Objects.equals(this.tipoServicio, other.tipoServicio)) {
			return false;
		}
		if(!Objects.equals(this.seriePago, other.seriePago)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.codigoPago);
		hash = 59 * hash + Objects.hashCode(this.tipoServicio);
		hash = 59 * hash + Objects.hashCode(this.seriePago);
		return hash;
	}
}
