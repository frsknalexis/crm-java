package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ConsolidadoInternetResultViewModel;

public class ConsolidadoInternetResultViewModelMapper implements RowMapper<ConsolidadoInternetResultViewModel> {

	@Override
	public ConsolidadoInternetResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ConsolidadoInternetResultViewModel consolidadoInternet = new ConsolidadoInternetResultViewModel();
		consolidadoInternet.setFechaPago(rs.getString("fecha_pago_dia"));
		consolidadoInternet.setCajaUno(rs.getString("CAJA_1"));
		consolidadoInternet.setCajaDos(rs.getString("CAJA_2"));
		consolidadoInternet.setCajaTres(rs.getString("CAJA_3"));
		return consolidadoInternet;
	}
}
