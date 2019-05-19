package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ClienteAtencionDetalleResultViewModel;

public class ClienteAtencionDetalleResultViewModelMapper implements RowMapper<ClienteAtencionDetalleResultViewModel> {

	@Override
	public ClienteAtencionDetalleResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClienteAtencionDetalleResultViewModel clienteAtencionDetalle = new ClienteAtencionDetalleResultViewModel();
		clienteAtencionDetalle.setDocumentoPersonaCliente(rs.getString("documento_personac"));
		clienteAtencionDetalle.setHerramienta(rs.getString("HERRAMIENTA"));
		clienteAtencionDetalle.setFaltas(rs.getInt("FALTA"));
		return clienteAtencionDetalle;
	}

}
