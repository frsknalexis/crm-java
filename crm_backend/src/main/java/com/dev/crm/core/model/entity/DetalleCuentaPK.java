package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class DetalleCuentaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4017859423711793502L;

	private String tipoServicio;
	
	private String documentoPersonaCliente;
	
	private Integer codigoDetalleCuenta;
	
	private Integer codigoCuenta;
	
	private String codigoAnio;
	
	private Integer consecutivoCliente;

	public DetalleCuentaPK() {
		
	}

	public DetalleCuentaPK(String tipoServicio, String documentoPersonaCliente, Integer codigoDetalleCuenta, Integer codigoCuenta,
			String codigoAnio, Integer consecutivoCliente) {
		super();
		this.tipoServicio = tipoServicio;
		this.documentoPersonaCliente = documentoPersonaCliente;
		this.codigoDetalleCuenta = codigoDetalleCuenta;
		this.codigoCuenta = codigoCuenta;
		this.codigoAnio = codigoAnio;
		this.consecutivoCliente = consecutivoCliente;
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
		final DetalleCuentaPK other = (DetalleCuentaPK) obj;
		if(!Objects.equals(this.tipoServicio, other.tipoServicio)) {
			return false;
		}
		if(!Objects.equals(this.documentoPersonaCliente, other.documentoPersonaCliente)) {
			return false;
		}
		if(!Objects.equals(this.codigoDetalleCuenta, other.codigoDetalleCuenta)) {
			return false;
		}
		if(!Objects.equals(this.codigoCuenta, other.codigoCuenta)) {
			return false;
		}
		if(!Objects.equals(this.codigoAnio, other.codigoAnio)) {
			return false;
		}
		if(!Objects.equals(this.consecutivoCliente, other.consecutivoCliente)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.tipoServicio);
		hash = 59 * hash + Objects.hashCode(this.documentoPersonaCliente);
		hash = 59 * hash + Objects.hashCode(this.codigoDetalleCuenta);
		hash = 59 * hash + Objects.hashCode(this.codigoCuenta);
		hash = 59 * hash + Objects.hashCode(this.codigoAnio);
		hash = 59 * hash + Objects.hashCode(this.consecutivoCliente);
		return hash;
	}
}
