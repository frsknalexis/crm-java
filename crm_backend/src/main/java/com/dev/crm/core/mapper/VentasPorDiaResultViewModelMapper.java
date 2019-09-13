package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.VentasPorDiaResultViewModel;

public class VentasPorDiaResultViewModelMapper implements RowMapper<VentasPorDiaResultViewModel> {

	@Override
	public VentasPorDiaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		VentasPorDiaResultViewModel ventasPorDia = new VentasPorDiaResultViewModel();
		ventasPorDia.setFechaSolicitudCliente(rs.getString("fechacli_detcue"));
		ventasPorDia.setTotal(rs.getBigDecimal("total"));
		return ventasPorDia;
	}
}
