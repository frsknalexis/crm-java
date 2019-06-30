package com.dev.crm.core.mapper;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PagosDelDiaResultViewModel;

public class PagosDelDiaResultViewModelMapper implements RowMapper<PagosDelDiaResultViewModel> {

	@Override
	public PagosDelDiaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PagosDelDiaResultViewModel pagosDelDia = new PagosDelDiaResultViewModel();
		pagosDelDia.setCodigoPago(rs.getInt("codigo_pago"));
		pagosDelDia.setDescuento((rs.getBigDecimal("descuento")).setScale(2, RoundingMode.HALF_UP));
		pagosDelDia.setCantidadPago((rs.getBigDecimal("cant_pago")).setScale(2, RoundingMode.HALF_UP));
		pagosDelDia.setMesValido(rs.getString("mes_valido"));
		pagosDelDia.setAnioValido(rs.getString("anio_valido"));
		pagosDelDia.setCliente(rs.getString("CLIENTE"));
		pagosDelDia.setDireccionActualCliente(rs.getString("direccióna_persona"));
		pagosDelDia.setFechaPagoDia(rs.getDate("fecha_pago_dia"));
		return pagosDelDia;
	}

}
