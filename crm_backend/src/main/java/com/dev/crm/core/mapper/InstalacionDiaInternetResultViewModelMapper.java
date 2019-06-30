package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;

public class InstalacionDiaInternetResultViewModelMapper implements RowMapper<InstalacionDiaInternetResultViewModel> {

	@Override
	public InstalacionDiaInternetResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		InstalacionDiaInternetResultViewModel instalacionDiaInternet = new InstalacionDiaInternetResultViewModel();
		instalacionDiaInternet.setCodigoDetalleCuenta(rs.getInt("codi_detcun"));
		instalacionDiaInternet.setCliente(rs.getString("cliente"));
		instalacionDiaInternet.setDireccionActualCliente(rs.getString("direccióna_persona"));
		instalacionDiaInternet.setReferenciaDireccion(rs.getString("referencia_persona"));
		instalacionDiaInternet.setTelefonoCliente(rs.getString("telefonou_persona"));
		instalacionDiaInternet.setDocumentoPersonaCliente(rs.getString("documento_persona"));
		instalacionDiaInternet.setCodigoCuenta(rs.getInt("codi_cuenta"));
		instalacionDiaInternet.setFechaInstalacion(rs.getDate("fechacli_detcue"));
		return instalacionDiaInternet;
	}

}
