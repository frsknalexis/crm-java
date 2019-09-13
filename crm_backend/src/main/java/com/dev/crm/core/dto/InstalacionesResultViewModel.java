package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class InstalacionesResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8938244448104262925L;

	private String fechaInstalacion;
	
	private BigDecimal totalInstalacion;

	public InstalacionesResultViewModel() {
		
	}

	public String getFechaInstalacion() {
		return fechaInstalacion;
	}

	public void setFechaInstalacion(String fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}

	public BigDecimal getTotalInstalacion() {
		return totalInstalacion;
	}

	public void setTotalInstalacion(BigDecimal totalInstalacion) {
		this.totalInstalacion = totalInstalacion;
	}
}
