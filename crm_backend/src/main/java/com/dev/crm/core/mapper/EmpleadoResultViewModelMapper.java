package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.EmpleadoResultViewModel;

public class EmpleadoResultViewModelMapper implements RowMapper<EmpleadoResultViewModel> {

	@Override
	public EmpleadoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EmpleadoResultViewModel empleadoResultViewModel = new EmpleadoResultViewModel();
		empleadoResultViewModel.setDocumentoPersonaEmpleado(rs.getString("documento_personae"));
		empleadoResultViewModel.setEmpleado(rs.getString("Empleado"));
		empleadoResultViewModel.setDireccionPersonaEmpleado(rs.getString("direccióna_persona"));
		empleadoResultViewModel.setTelefonoPersonaEmpleado(rs.getString("telefonou_persona"));
		empleadoResultViewModel.setDescripcionCargo(rs.getString("descripcion_cargo"));
		empleadoResultViewModel.setValue(rs.getInt("Value"));
		empleadoResultViewModel.setTof(rs.getInt("TOF"));
		empleadoResultViewModel.setFot(rs.getInt("FOT"));
		return empleadoResultViewModel;
	}

}
