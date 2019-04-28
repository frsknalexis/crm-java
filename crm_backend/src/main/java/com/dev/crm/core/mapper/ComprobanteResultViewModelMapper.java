package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ComprobanteResultViewModel;

public class ComprobanteResultViewModelMapper implements RowMapper<ComprobanteResultViewModel> {

	@Override
	public ComprobanteResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ComprobanteResultViewModel comprobanteResultViewModel = new ComprobanteResultViewModel();
		comprobanteResultViewModel.setCodigoComprobante(rs.getBigDecimal("codigo_comprobante"));
		comprobanteResultViewModel.setDescripcionComprobante(rs.getString("descripcion_comprobante"));
		return comprobanteResultViewModel;
	}

	
}
