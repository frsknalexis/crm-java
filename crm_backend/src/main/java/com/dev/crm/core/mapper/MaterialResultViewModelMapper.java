package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.MaterialResultViewModel;

public class MaterialResultViewModelMapper implements RowMapper<MaterialResultViewModel> {

	@Override
	public MaterialResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MaterialResultViewModel material = new MaterialResultViewModel();
		material.setMaterialId(rs.getInt("id_mate"));
		material.setDescripcion(rs.getString("descripcion"));
		return material;
	}
}
