package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ListaPagosPorCajaResultViewModel;

public class PagosPorCajaResultViewModelMapper implements RowMapper<ListaPagosPorCajaResultViewModel> {

	@Override
	public ListaPagosPorCajaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ListaPagosPorCajaResultViewModel pagosPorCaja = new ListaPagosPorCajaResultViewModel();
		pagosPorCaja.setCliente(rs.getString("cliente"));
		pagosPorCaja.setMarzo(rs.getString("marzo"));
		pagosPorCaja.setAbril(rs.getString("abril"));
		pagosPorCaja.setMayo(rs.getString("mayo"));
		pagosPorCaja.setJunio(rs.getString("junio"));
		pagosPorCaja.setJulio(rs.getString("julio"));
		return pagosPorCaja;
	}
}
