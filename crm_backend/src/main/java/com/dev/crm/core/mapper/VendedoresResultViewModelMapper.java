package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.VendedoresResultViewModel;

public class VendedoresResultViewModelMapper implements RowMapper<VendedoresResultViewModel> {

	@Override
	public VendedoresResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		VendedoresResultViewModel vendedores = new VendedoresResultViewModel();
		vendedores.setVendedor(rs.getString("vendedor"));
		vendedores.setDocumentoPersonaVendedor(rs.getString("documento_persona"));
		return vendedores;
	}
}
