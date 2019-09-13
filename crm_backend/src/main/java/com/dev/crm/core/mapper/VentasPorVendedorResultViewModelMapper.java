package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.VentasPorVendedorResultViewModel;

public class VentasPorVendedorResultViewModelMapper implements RowMapper<VentasPorVendedorResultViewModel> {

	@Override
	public VentasPorVendedorResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		VentasPorVendedorResultViewModel ventasPorVendedor = new VentasPorVendedorResultViewModel();
		ventasPorVendedor.setNombreVendedor(rs.getString("nombrevendedorurgencia"));
		ventasPorVendedor.setTotalVenta(rs.getBigDecimal("total"));
		return ventasPorVendedor;
	}
}
