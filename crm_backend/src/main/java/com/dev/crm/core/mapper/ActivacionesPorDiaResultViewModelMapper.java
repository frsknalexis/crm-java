package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ActivacionesPorDiaResultViewModel;

public class ActivacionesPorDiaResultViewModelMapper implements RowMapper<ActivacionesPorDiaResultViewModel> {

	@Override
	public ActivacionesPorDiaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ActivacionesPorDiaResultViewModel activacionesPorDia = new ActivacionesPorDiaResultViewModel();
		activacionesPorDia.setNumeracion(rs.getInt("NU"));
		activacionesPorDia.setCliente(rs.getString("cliente"));
		activacionesPorDia.setDocumentoPersonaCliente(rs.getString("documento_persona"));
		activacionesPorDia.setDireccionCliente(rs.getString("direccióna_persona"));
		activacionesPorDia.setFechaInicioServicio(rs.getDate("fechainicio_serin"));
		activacionesPorDia.setInternet(rs.getString("internet"));
		activacionesPorDia.setUbicacion(rs.getString("nombre_ubigeo"));
		activacionesPorDia.setObservacion(rs.getString("observacion_serin"));
		return activacionesPorDia;
	}
}
