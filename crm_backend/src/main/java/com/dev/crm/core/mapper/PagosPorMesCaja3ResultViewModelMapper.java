package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PagosPorMesCaja3ResultViewModel;

public class PagosPorMesCaja3ResultViewModelMapper implements RowMapper<PagosPorMesCaja3ResultViewModel> {

	@Override
	public PagosPorMesCaja3ResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PagosPorMesCaja3ResultViewModel pagosPorMesCaja = new PagosPorMesCaja3ResultViewModel();
		pagosPorMesCaja.setDiaFechaPago(rs.getString("fecha_pago_dia"));
		pagosPorMesCaja.setCantidadPago(rs.getBigDecimal("cant_pago"));
		return pagosPorMesCaja;
	}
}
