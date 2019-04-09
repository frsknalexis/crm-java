package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SexoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2823729380778748683L;

	private BigDecimal codigoSexo;
	
	private String descripcionSexo;
	
	@JsonIgnore
	private List<ClienteDTO> clientes;

	public SexoDTO() {
		clientes = new ArrayList<ClienteDTO>();
	}

	public BigDecimal getCodigoSexo() {
		return codigoSexo;
	}

	public void setCodigoSexo(BigDecimal codigoSexo) {
		this.codigoSexo = codigoSexo;
	}

	public String getDescripcionSexo() {
		return descripcionSexo;
	}

	public void setDescripcionSexo(String descripcionSexo) {
		this.descripcionSexo = descripcionSexo;
	}

	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
	}
}
