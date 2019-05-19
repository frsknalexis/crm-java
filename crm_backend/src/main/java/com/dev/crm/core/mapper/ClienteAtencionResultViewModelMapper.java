package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ClienteAtencionResultViewModel;

public class ClienteAtencionResultViewModelMapper implements RowMapper<ClienteAtencionResultViewModel> {

	@Override
	public ClienteAtencionResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClienteAtencionResultViewModel clienteAtencion = new ClienteAtencionResultViewModel();
		clienteAtencion.setEstado(rs.getInt("ESTADO"));
		clienteAtencion.setDocumentoPersonaCliente(rs.getString("documento_personac"));
		clienteAtencion.setClientenombre(rs.getString("cliente"));
		clienteAtencion.setHerramienta(rs.getString("HERRAMIENTA"));
		clienteAtencion.setFalta(rs.getInt("FALTA"));
		return clienteAtencion;
	}

}
