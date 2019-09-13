package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.CuentasInstaladasResultViewModel;

public class CuentasInstaladasResultViewModelMapper implements RowMapper<CuentasInstaladasResultViewModel> {

	@Override
	public CuentasInstaladasResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CuentasInstaladasResultViewModel cuentasInstaladas = new CuentasInstaladasResultViewModel();
		cuentasInstaladas.setNumeracion(rs.getInt("NU"));
		cuentasInstaladas.setCodigoDetalleCuenta(rs.getInt("codi_detcun"));
		cuentasInstaladas.setCodigoCuenta(rs.getInt("codi_cuenta"));
		cuentasInstaladas.setCliente(rs.getString("cliente"));
		cuentasInstaladas.setObservacion(rs.getString("observacion_detcue"));
		cuentasInstaladas.setDocumentoCliente(rs.getString("documento_persona"));
		return cuentasInstaladas;
	}
}
