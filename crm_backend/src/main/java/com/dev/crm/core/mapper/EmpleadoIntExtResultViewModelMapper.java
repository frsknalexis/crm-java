package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.EmpleadoEXTINTResultViewModel;

public class EmpleadoIntExtResultViewModelMapper implements RowMapper<EmpleadoEXTINTResultViewModel> {

	@Override
	public EmpleadoEXTINTResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EmpleadoEXTINTResultViewModel empleadoResultViewModel = new EmpleadoEXTINTResultViewModel();
		empleadoResultViewModel.setDocumentopersonaempleado(rs.getString("documento_personae"));
		empleadoResultViewModel.setCodigoempleado(rs.getString("codigo_empleado"));
		empleadoResultViewModel.setEmpleadonombre(rs.getString("Empleado"));
		empleadoResultViewModel.setDireccionempleado(rs.getString("direccióna_persona"));
		empleadoResultViewModel.setTelefonoprinciaplempleado(rs.getString("telefonou_persona"));
		empleadoResultViewModel.setCargoempleado(rs.getString("descripcion_cargo"));
		empleadoResultViewModel.setValueestado(rs.getInt("Value"));
		empleadoResultViewModel.setActivointerno(rs.getInt("TOF"));
		empleadoResultViewModel.setActivoexterno(rs.getInt("FOT"));
		return empleadoResultViewModel;
	}

}
