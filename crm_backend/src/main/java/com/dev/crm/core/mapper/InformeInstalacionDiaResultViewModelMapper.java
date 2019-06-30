package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.InformeInstalacionDiaResultViewModel;

public class InformeInstalacionDiaResultViewModelMapper implements RowMapper<InformeInstalacionDiaResultViewModel> {

	@Override
	public InformeInstalacionDiaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		InformeInstalacionDiaResultViewModel informeInstalacionDia = new InformeInstalacionDiaResultViewModel();
		informeInstalacionDia.setCodigoDetalleCuenta(rs.getInt("codi_detcun"));
		informeInstalacionDia.setDocumentoPersonaCliente(rs.getString("documento_personac"));
		informeInstalacionDia.setCodigoCuenta(rs.getInt("codi_cuenta"));
		informeInstalacionDia.setEstadoInstalacion(rs.getString("est_detcun"));
		informeInstalacionDia.setCliente(rs.getString("CLIENTE"));
		informeInstalacionDia.setTecnicoResponsable(rs.getString("TECNICO"));
		return informeInstalacionDia;
	}
}
