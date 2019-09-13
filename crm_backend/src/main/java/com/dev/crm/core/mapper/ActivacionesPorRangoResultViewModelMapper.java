package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ActivacionesPorRangoResultViewModel;

public class ActivacionesPorRangoResultViewModelMapper implements RowMapper<ActivacionesPorRangoResultViewModel> {

	@Override
	public ActivacionesPorRangoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ActivacionesPorRangoResultViewModel activacionesPorRango = new ActivacionesPorRangoResultViewModel();
		activacionesPorRango.setNumeracion(rs.getInt("NU"));
		activacionesPorRango.setCliente(rs.getString("cliente"));
		activacionesPorRango.setDocumentoCliente(rs.getString("documento_persona"));
		activacionesPorRango.setDireccionCliente(rs.getString("direccióna_persona"));
		activacionesPorRango.setFechaInicioServicio(rs.getDate("fechainicio_serin"));
		activacionesPorRango.setInternet(rs.getString("internet"));
		activacionesPorRango.setUbicacion(rs.getString("nombre_ubigeo"));
		activacionesPorRango.setObservacion(rs.getString("observacion_serin"));
		return activacionesPorRango;
	}
}
