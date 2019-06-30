package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.GestoresResultViewModel;

public class GestoresResultViewModelMapper implements RowMapper<GestoresResultViewModel> {

	@Override
	public GestoresResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GestoresResultViewModel gestores = new GestoresResultViewModel();
		gestores.setGestor(rs.getString("gestor"));
		gestores.setDocumentoPersonaGestor(rs.getString("documento_persona"));
		return gestores;
	}
}
