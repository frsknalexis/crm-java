package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.EstadosCuentaResultViewModel;

public class EstadosCuentaResultViewModelMapper implements RowMapper<EstadosCuentaResultViewModel> {

	@Override
	public EstadosCuentaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EstadosCuentaResultViewModel estadosCuenta = new EstadosCuentaResultViewModel();
		estadosCuenta.setCodigoEstado(rs.getInt("codi_estado"));
		estadosCuenta.setEstado(rs.getString("descripcion_estado"));
		return estadosCuenta;
	}
}
