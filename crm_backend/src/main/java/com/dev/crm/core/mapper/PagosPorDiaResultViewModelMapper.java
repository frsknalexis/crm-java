package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PagosPorDiaResultViewModel;

public class PagosPorDiaResultViewModelMapper implements RowMapper<PagosPorDiaResultViewModel> {

	@Override
	public PagosPorDiaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PagosPorDiaResultViewModel pagosPorDia = new PagosPorDiaResultViewModel();
		pagosPorDia.setCodigoPago(rs.getInt("codigo_pago"));
		pagosPorDia.setMesPago(rs.getString("mes_pago"));
		pagosPorDia.setMonto(rs.getBigDecimal("cant_pago"));
		pagosPorDia.setFechaPago(rs.getDate("fecha_pago_dia"));
		pagosPorDia.setCliente(rs.getString("cliente"));
		return pagosPorDia;
	}
}
