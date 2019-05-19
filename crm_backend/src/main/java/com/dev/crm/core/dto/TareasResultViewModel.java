package com.dev.crm.core.dto;

import java.io.Serializable;

public class TareasResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8918888252821672128L;
	
	private Integer estadotarea;
	
	private String nombrepersona;
	
	private String descripciontarea;

	public TareasResultViewModel() {
		
	}

	public Integer getEstadotarea() {
		return estadotarea;
	}

	public void setEstadotarea(Integer estadotarea) {
		this.estadotarea = estadotarea;
	}

	public String getNombrepersona() {
		return nombrepersona;
	}

	public void setNombrepersona(String nombrepersona) {
		this.nombrepersona = nombrepersona;
	}

	public String getDescripciontarea() {
		return descripciontarea;
	}

	public void setDescripciontarea(String descripciontarea) {
		this.descripciontarea = descripciontarea;
	}
	
}
