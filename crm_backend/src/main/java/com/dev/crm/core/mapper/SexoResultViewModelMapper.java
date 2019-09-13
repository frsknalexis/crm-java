package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.SexoResultViewModel;

public class SexoResultViewModelMapper implements RowMapper<SexoResultViewModel> {

	@Override
	public SexoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SexoResultViewModel listaSexo = new SexoResultViewModel();
		listaSexo.setCodigoSexo(rs.getInt("codigo_sexo"));
		listaSexo.setDescripcionSexo(rs.getString("descripcion_sexo"));
		return listaSexo;
	}
}
