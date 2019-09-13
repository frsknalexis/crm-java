package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.EstadoCuentasResultViewModel;

public class EstadoCuentasResultViewModelMapper implements RowMapper<EstadoCuentasResultViewModel> {

	@Override
	public EstadoCuentasResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EstadoCuentasResultViewModel estadoCuentas = new EstadoCuentasResultViewModel();
		estadoCuentas.setCodigoDetalleCuenta(rs.getInt("codi_detcun"));
		estadoCuentas.setCodigoCuenta(rs.getInt("codi_cuenta"));
		estadoCuentas.setDocumentoPersonaCliente(rs.getString("documento_personac"));
		estadoCuentas.setCliente(rs.getString("cliente"));
		estadoCuentas.setDireccionCliente(rs.getString("direccióna_persona"));
		estadoCuentas.setEstado(rs.getString("estado"));
		return estadoCuentas;
	}
}
