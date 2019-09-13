package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.InstalacionesResultViewModel;

public class InstalacionesResultViewModelMapper implements RowMapper<InstalacionesResultViewModel> {

	@Override
	public InstalacionesResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		InstalacionesResultViewModel instalacionesRealizadas = new InstalacionesResultViewModel();
		instalacionesRealizadas.setFechaInstalacion(rs.getString("fechainicio_serin"));
		instalacionesRealizadas.setTotalInstalacion(rs.getBigDecimal("total"));
		return instalacionesRealizadas;
	}
}
