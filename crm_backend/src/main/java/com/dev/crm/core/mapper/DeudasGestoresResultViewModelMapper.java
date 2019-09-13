package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.DeudasGestoresResultViewModel;

public class DeudasGestoresResultViewModelMapper implements RowMapper<DeudasGestoresResultViewModel> {

	@Override
	public DeudasGestoresResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DeudasGestoresResultViewModel deudasGestores = new DeudasGestoresResultViewModel();
		deudasGestores.setNumeracion(rs.getInt("NU"));
		deudasGestores.setCodigoCuenta(rs.getInt("cod"));
		deudasGestores.setDocumentoPersonaCliente(rs.getString("dniru"));
		deudasGestores.setMesPago(rs.getString("mesdepago"));
		deudasGestores.setDireccionCliente(rs.getString("direcciona_persona"));
		deudasGestores.setCliente(rs.getString("cliente"));
		deudasGestores.setReferencia(rs.getString("referencia_persona"));
		return deudasGestores;
	}
}
