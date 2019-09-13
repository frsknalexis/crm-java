package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.InstalacionesPorTecnicoResultViewModel;

public class InstalacionesPorTecnicoResultViewModelMapper implements RowMapper<InstalacionesPorTecnicoResultViewModel> {

	@Override
	public InstalacionesPorTecnicoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		InstalacionesPorTecnicoResultViewModel instalaciones = new InstalacionesPorTecnicoResultViewModel();
		instalaciones.setCodigoServicioInternet(rs.getInt("codi_serin"));
		instalaciones.setDocumentoPersona(rs.getString("documento_personac"));
		instalaciones.setCliente(rs.getString("cliente"));
		instalaciones.setTecnico(rs.getString("tecnico"));
		return instalaciones;
	}
}
