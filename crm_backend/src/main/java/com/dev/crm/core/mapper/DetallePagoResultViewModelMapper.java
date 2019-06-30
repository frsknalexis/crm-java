package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.DetallePagoResultViewModel;

public class DetallePagoResultViewModelMapper implements RowMapper<DetallePagoResultViewModel> {

	@Override
	public DetallePagoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DetallePagoResultViewModel Dpago = new DetallePagoResultViewModel();
		Dpago.setTotalpago(rs.getDouble("totapago"));
		Dpago.setDescuentototal(rs.getFloat("descuento"));
		Dpago.setCantidadpago(rs.getFloat("cant_pago"));
		Dpago.setFechadepago(rs.getString("fecha_pago_dia"));
		Dpago.setInformacionpago(rs.getString("mes_valido"));
		return Dpago;
	}

}
