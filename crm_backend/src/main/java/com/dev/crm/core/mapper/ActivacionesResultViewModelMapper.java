package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ActivacionesResultViewModel;

public class ActivacionesResultViewModelMapper implements RowMapper<ActivacionesResultViewModel> {

	@Override
	public ActivacionesResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ActivacionesResultViewModel activacionesInstalacion = new ActivacionesResultViewModel();
		activacionesInstalacion.setNumeracion(rs.getInt("NU"));
		activacionesInstalacion.setCliente(rs.getString("cliente"));
		activacionesInstalacion.setDocumentoPersonaCliente(rs.getString("documento_persona"));
		activacionesInstalacion.setDireccionCliente(rs.getString("direccióna_persona"));
		activacionesInstalacion.setFechaInicioServicio(rs.getDate("fechainicio_serin"));
		activacionesInstalacion.setInternet(rs.getString("internet"));
		activacionesInstalacion.setUbicacion(rs.getString("nombre_ubigeo"));
		activacionesInstalacion.setObservacion(rs.getString("observacion_serin"));
		return activacionesInstalacion;
	}
}
