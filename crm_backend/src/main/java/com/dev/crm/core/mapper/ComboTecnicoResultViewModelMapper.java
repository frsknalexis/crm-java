package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.AsignarTecnicoComboResultViewModel;

public class ComboTecnicoResultViewModelMapper implements RowMapper<AsignarTecnicoComboResultViewModel> {

	@Override
	public AsignarTecnicoComboResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AsignarTecnicoComboResultViewModel clienteAtencion = new AsignarTecnicoComboResultViewModel();
		clienteAtencion.setTecnicoescogigo(rs.getString("EMPLEADO"));
		return clienteAtencion;
	}

}
