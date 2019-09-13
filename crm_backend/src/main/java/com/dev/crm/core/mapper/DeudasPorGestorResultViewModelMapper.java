package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.DeudasPorGestorResultViewModel;

public class DeudasPorGestorResultViewModelMapper implements RowMapper<DeudasPorGestorResultViewModel> {

	@Override
	public DeudasPorGestorResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DeudasPorGestorResultViewModel deudasPorGestor = new DeudasPorGestorResultViewModel();
		deudasPorGestor.setDeuda(rs.getString("mesdepago"));
		deudasPorGestor.setDireccionCliente(rs.getString("direcciona_persona"));
		deudasPorGestor.setCliente(rs.getString("cliente"));
		deudasPorGestor.setMesDeuda(rs.getString("mesescompre"));
		return deudasPorGestor;
	}
}
