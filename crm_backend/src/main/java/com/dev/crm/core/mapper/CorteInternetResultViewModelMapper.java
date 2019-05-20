package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.CorteInternetResultViewModel;

public class CorteInternetResultViewModelMapper implements RowMapper<CorteInternetResultViewModel> {

	@Override
	public CorteInternetResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CorteInternetResultViewModel corteInternet = new CorteInternetResultViewModel();
		corteInternet.setDeudaTotal(rs.getBigDecimal("debe_total"));
		corteInternet.setDocumentoPersonaCliente(rs.getString("documento_internet"));
		corteInternet.setCliente(rs.getString("CLIENTE"));
		corteInternet.setCodigoServicioInternet(rs.getInt("codi_serin"));
		return corteInternet;
	}
}
