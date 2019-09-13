package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.CuentasRangoResultViewModel;

public class CuentasRangoResultViewModelMapper implements RowMapper<CuentasRangoResultViewModel> {

	@Override
	public CuentasRangoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CuentasRangoResultViewModel cuentasPorRango = new CuentasRangoResultViewModel();
		cuentasPorRango.setNumeracion(rs.getInt("NU"));
		cuentasPorRango.setCodigoDetalleCuenta(rs.getInt("codi_detcun"));
		cuentasPorRango.setCodigoCuenta(rs.getInt("codi_cuenta"));
		cuentasPorRango.setCliente(rs.getString("cliente"));
		cuentasPorRango.setObservacion(rs.getString("observacion_detcue"));
		cuentasPorRango.setDocumentoPersona(rs.getString("documento_persona"));
		return cuentasPorRango;
	}
}
