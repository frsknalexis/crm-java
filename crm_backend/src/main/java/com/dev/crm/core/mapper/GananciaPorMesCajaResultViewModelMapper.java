package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.GananciaPorMesCajaResultViewModel;

public class GananciaPorMesCajaResultViewModelMapper implements RowMapper<GananciaPorMesCajaResultViewModel> {

	@Override
	public GananciaPorMesCajaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GananciaPorMesCajaResultViewModel gananciaPorMesCaja = new GananciaPorMesCajaResultViewModel();
		gananciaPorMesCaja.setCaja(rs.getString("CAJA"));
		gananciaPorMesCaja.setCantidadPago(rs.getBigDecimal("cant_pago"));
		return gananciaPorMesCaja;
	}
}
