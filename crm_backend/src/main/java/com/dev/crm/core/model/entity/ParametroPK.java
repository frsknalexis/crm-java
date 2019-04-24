package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class ParametroPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5714214217778552260L;

	private String codigoParametro;
	
	private String nombreEmpresa;

	public ParametroPK() {
	
	}

	public ParametroPK(String codigoParametro, String nombreEmpresa) {
		super();
		this.codigoParametro = codigoParametro;
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getCodigoParametro() {
		return codigoParametro;
	}

	public void setCodigoParametro(String codigoParametro) {
		this.codigoParametro = codigoParametro;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
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
		final ParametroPK other = (ParametroPK) obj;
		if(!Objects.equals(this.codigoParametro, other.codigoParametro)) {
			return false;
		}
		if(!Objects.equals(this.nombreEmpresa, other.nombreEmpresa)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.codigoParametro);
		hash = 59 * hash + Objects.hashCode(this.nombreEmpresa);
		return hash;
	}
}
