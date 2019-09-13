package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.DiasDeudasResultViewModel;

public class DiasDeudasResultViewModelMapper implements RowMapper<DiasDeudasResultViewModel> {

	@Override
	public DiasDeudasResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DiasDeudasResultViewModel diasDeudas = new DiasDeudasResultViewModel();
		diasDeudas.setNumeracion(rs.getInt("NU"));
		diasDeudas.setCodigoCuenta(rs.getInt("cod"));
		diasDeudas.setDocumentoPersonaCliente(rs.getString("dniru"));
		diasDeudas.setMesPago(rs.getString("mesdepago"));
		diasDeudas.setDireccionCliente(rs.getString("direcciona_persona"));
		diasDeudas.setCliente(rs.getString("cliente"));
		return diasDeudas;
	}
}
