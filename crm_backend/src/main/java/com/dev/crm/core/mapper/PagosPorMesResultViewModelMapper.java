package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PagosPorMesResultViewModel;

public class PagosPorMesResultViewModelMapper implements RowMapper<PagosPorMesResultViewModel> {

	@Override
	public PagosPorMesResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PagosPorMesResultViewModel pagosPorMes = new PagosPorMesResultViewModel();
		pagosPorMes.setDiaFechaPago(rs.getString("fecha_pago_dia"));
		pagosPorMes.setCantidadPago(rs.getBigDecimal("cant_pago"));
		return pagosPorMes;
	}	
}
