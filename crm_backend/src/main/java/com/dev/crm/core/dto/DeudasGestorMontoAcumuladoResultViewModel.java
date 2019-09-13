package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DeudasGestorMontoAcumuladoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8214345349375609393L;

	private String gestor;
	
	private BigDecimal morosidadUnMes;
	
	private Integer morosidadUnMesCantidad;
	
	private BigDecimal morosidadDosMeses;
	
	private Integer morosidadDosMesesCantidad;
	
	private BigDecimal morosidadTresMeses;
	
	private Integer morosidadTresMesesCantidad;
	
	private BigDecimal morosidadCuatroMeses;
	
	private Integer morosidadCuatroMesesCantidad;
	
	private BigDecimal morosidadCincoMeses;
	
	private Integer morosidadCincoMesesCantidad;

	public DeudasGestorMontoAcumuladoResultViewModel() {
		
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public BigDecimal getMorosidadUnMes() {
		return morosidadUnMes;
	}

	public void setMorosidadUnMes(BigDecimal morosidadUnMes) {
		this.morosidadUnMes = morosidadUnMes;
	}

	public Integer getMorosidadUnMesCantidad() {
		return morosidadUnMesCantidad;
	}

	public void setMorosidadUnMesCantidad(Integer morosidadUnMesCantidad) {
		this.morosidadUnMesCantidad = morosidadUnMesCantidad;
	}

	public BigDecimal getMorosidadDosMeses() {
		return morosidadDosMeses;
	}

	public void setMorosidadDosMeses(BigDecimal morosidadDosMeses) {
		this.morosidadDosMeses = morosidadDosMeses;
	}

	public Integer getMorosidadDosMesesCantidad() {
		return morosidadDosMesesCantidad;
	}

	public void setMorosidadDosMesesCantidad(Integer morosidadDosMesesCantidad) {
		this.morosidadDosMesesCantidad = morosidadDosMesesCantidad;
	}

	public BigDecimal getMorosidadTresMeses() {
		return morosidadTresMeses;
	}

	public void setMorosidadTresMeses(BigDecimal morosidadTresMeses) {
		this.morosidadTresMeses = morosidadTresMeses;
	}

	public Integer getMorosidadTresMesesCantidad() {
		return morosidadTresMesesCantidad;
	}

	public void setMorosidadTresMesesCantidad(Integer morosidadTresMesesCantidad) {
		this.morosidadTresMesesCantidad = morosidadTresMesesCantidad;
	}

	public BigDecimal getMorosidadCuatroMeses() {
		return morosidadCuatroMeses;
	}

	public void setMorosidadCuatroMeses(BigDecimal morosidadCuatroMeses) {
		this.morosidadCuatroMeses = morosidadCuatroMeses;
	}

	public Integer getMorosidadCuatroMesesCantidad() {
		return morosidadCuatroMesesCantidad;
	}

	public void setMorosidadCuatroMesesCantidad(Integer morosidadCuatroMesesCantidad) {
		this.morosidadCuatroMesesCantidad = morosidadCuatroMesesCantidad;
	}

	public BigDecimal getMorosidadCincoMeses() {
		return morosidadCincoMeses;
	}

	public void setMorosidadCincoMeses(BigDecimal morosidadCincoMeses) {
		this.morosidadCincoMeses = morosidadCincoMeses;
	}

	public Integer getMorosidadCincoMesesCantidad() {
		return morosidadCincoMesesCantidad;
	}

	public void setMorosidadCincoMesesCantidad(Integer morosidadCincoMesesCantidad) {
		this.morosidadCincoMesesCantidad = morosidadCincoMesesCantidad;
	}
}
