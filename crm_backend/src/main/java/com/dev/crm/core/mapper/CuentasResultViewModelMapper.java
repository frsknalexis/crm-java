package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.CuentasResultViewModel;

public class CuentasResultViewModelMapper implements RowMapper<CuentasResultViewModel> {

	@Override
	public CuentasResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CuentasResultViewModel cuentasPorDia = new CuentasResultViewModel();
		cuentasPorDia.setNumeracion(rs.getInt("NU"));
		cuentasPorDia.setCodigoDetalleCuenta(rs.getInt("codi_detcun"));
		cuentasPorDia.setCodigoCuenta(rs.getInt("codi_cuenta"));
		cuentasPorDia.setCliente(rs.getString("cliente"));
		cuentasPorDia.setObservacion(rs.getString("observacion_detcue"));
		cuentasPorDia.setDocumentoPersona(rs.getString("documento_persona"));
		return cuentasPorDia;
	}
}
