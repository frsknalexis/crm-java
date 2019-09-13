package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PagosPorMesCaja1ResultViewModel;

public class PagosPorMesCaja1ResultViewModelMapper implements RowMapper<PagosPorMesCaja1ResultViewModel> {

	@Override
	public PagosPorMesCaja1ResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PagosPorMesCaja1ResultViewModel pagosPorMesCaja = new PagosPorMesCaja1ResultViewModel();
		pagosPorMesCaja.setDiaFechaPago(rs.getString("fecha_pago_dia"));
		pagosPorMesCaja.setCantidadPago(rs.getBigDecimal("cant_pago"));
		return pagosPorMesCaja;
	}
}
