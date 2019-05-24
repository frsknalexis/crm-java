package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ModuloResultViewModel;

public class ModuloResultViewModelMapper implements RowMapper<ModuloResultViewModel> {

	@Override
	public ModuloResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ModuloResultViewModel modulo = new ModuloResultViewModel();
		modulo.setNumeracionmodulo(rs.getString("NU"));
		modulo.setDescripcionmodulo(rs.getString("nombre_modulo"));
		return modulo;
	}

}
