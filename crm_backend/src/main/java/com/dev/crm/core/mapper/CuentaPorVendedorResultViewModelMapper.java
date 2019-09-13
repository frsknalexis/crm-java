package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.CuentaPorVendedorResultViewModel;

public class CuentaPorVendedorResultViewModelMapper implements RowMapper<CuentaPorVendedorResultViewModel> {

	@Override
	public CuentaPorVendedorResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CuentaPorVendedorResultViewModel cuentasPorVendedor = new CuentaPorVendedorResultViewModel();
		cuentasPorVendedor.setNumeracion(rs.getInt("NU"));
		cuentasPorVendedor.setCliente(rs.getString("cliente"));
		cuentasPorVendedor.setDireccionCliente(rs.getString("direccióna_persona"));
		cuentasPorVendedor.setEstado(rs.getString("estado"));
		cuentasPorVendedor.setFechaInicio(rs.getString("fechainicio"));
		return cuentasPorVendedor;
	}
}
