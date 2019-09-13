package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaResultViewModel;

public class PagosPorRangoFechaBusquedaResultViewModelMapper implements RowMapper<PagosPorRangoFechaBusquedaResultViewModel> {

	@Override
	public PagosPorRangoFechaBusquedaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PagosPorRangoFechaBusquedaResultViewModel pagosPorRangoFecha = new PagosPorRangoFechaBusquedaResultViewModel();
		pagosPorRangoFecha.setNumeracion(rs.getString("NU"));
		pagosPorRangoFecha.setCodigoPago(rs.getString("codigo_pago"));
		pagosPorRangoFecha.setMesPago(rs.getString("mes_pago"));
		pagosPorRangoFecha.setCantidadPago(rs.getString("cant_pago"));
		pagosPorRangoFecha.setFechaPagoDia(rs.getString("fecha_pago_dia"));
		pagosPorRangoFecha.setCliente(rs.getString("cliente"));
		return pagosPorRangoFecha;
	}
}
