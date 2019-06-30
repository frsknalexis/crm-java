package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.CuentasPorInstalarResultViewModel;

public class CuentasPorInstalarResultViewModelMapper implements RowMapper<CuentasPorInstalarResultViewModel> {

	@Override
	public CuentasPorInstalarResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CuentasPorInstalarResultViewModel cuentasPorInstalar = new CuentasPorInstalarResultViewModel();
		cuentasPorInstalar.setCodigoDetalleCuenta(rs.getInt("codi_detcun"));
		cuentasPorInstalar.setCodigoCuenta(rs.getInt("codi_cuenta"));
		cuentasPorInstalar.setDocumentoPersonaCliente(rs.getString("documento_personac"));
		cuentasPorInstalar.setCliente(rs.getString("cliente"));
		cuentasPorInstalar.setDireccionActualCliente(rs.getString("direccióna_persona"));
		cuentasPorInstalar.setFechaProgramacionInstalacion(rs.getDate("fechapro_detcue"));
		return cuentasPorInstalar;
	}
}
