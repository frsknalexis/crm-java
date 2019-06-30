package com.dev.crm.core.dto;

import java.io.Serializable;

public class MaterialResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -483981828570849487L;

	private Integer materialId;
	
	private String descripcion;

	public MaterialResultViewModel() {
		
	}

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
