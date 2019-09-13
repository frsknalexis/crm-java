package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PagoPorDiaResultViewModel;

public class PagoPorDiaResultViewModelMapper implements RowMapper<PagoPorDiaResultViewModel> {

	@Override
	public PagoPorDiaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PagoPorDiaResultViewModel pagosPorDia = new PagoPorDiaResultViewModel();
		pagosPorDia.setNumeroInterno(rs.getString("NU"));
		pagosPorDia.setCodigoPago(rs.getString("codigo_pago"));
		pagosPorDia.setMesPago(rs.getString("mes_pago"));
		pagosPorDia.setCantidadPago(rs.getString("cant_pago"));
		pagosPorDia.setFechaPago(rs.getString("fecha_pago_dia"));
		pagosPorDia.setCliente(rs.getString("cliente"));
		return pagosPorDia;
	}
}
