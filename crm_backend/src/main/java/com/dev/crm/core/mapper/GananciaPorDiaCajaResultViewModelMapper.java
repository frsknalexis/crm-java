package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.GananciaPorDiaCajaResultViewModel;

public class GananciaPorDiaCajaResultViewModelMapper implements RowMapper<GananciaPorDiaCajaResultViewModel> {

	@Override
	public GananciaPorDiaCajaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GananciaPorDiaCajaResultViewModel gananciaPorDiaCaja = new GananciaPorDiaCajaResultViewModel();
		gananciaPorDiaCaja.setCaja(rs.getString("CAJA"));
		gananciaPorDiaCaja.setCantidadPago(rs.getBigDecimal("cant_pago"));
		return gananciaPorDiaCaja;
	}
}
