package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PagosPorMesCaja2ResultViewModel;

public class PagosPorMesCaja2ResultViewModelMapper implements RowMapper<PagosPorMesCaja2ResultViewModel> {

	@Override
	public PagosPorMesCaja2ResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PagosPorMesCaja2ResultViewModel pagosPorMesCaja = new PagosPorMesCaja2ResultViewModel();
		pagosPorMesCaja.setDiaFechaPago(rs.getString("fecha_pago_dia"));
		pagosPorMesCaja.setCantidadPago(rs.getBigDecimal("cant_pago"));
		return pagosPorMesCaja;
	}
}
