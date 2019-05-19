package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.TareasResultViewModel;

public class TareaResultViewModelMapper implements RowMapper<TareasResultViewModel> {

	@Override
	public TareasResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TareasResultViewModel tarea = new TareasResultViewModel();
		tarea.setEstadotarea(rs.getInt("estadotarea"));
		tarea.setDescripciontarea(rs.getString("descripcion"));
		tarea.setNombrepersona(rs.getString("Persona"));
		return tarea;
	}

}
