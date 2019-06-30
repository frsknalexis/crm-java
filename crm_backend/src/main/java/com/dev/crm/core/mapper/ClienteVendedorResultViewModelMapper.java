package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ClienteVendedorResultViewModel;

public class ClienteVendedorResultViewModelMapper implements RowMapper<ClienteVendedorResultViewModel> {

	@Override
	public ClienteVendedorResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClienteVendedorResultViewModel cliente = new ClienteVendedorResultViewModel();
		cliente.setDocumentoPersonaCliente(rs.getString("documento_personac"));
		cliente.setNombreComercialCliente(rs.getString("nombrecom_cliente"));
		cliente.setCliente(rs.getString("cliente"));
		cliente.setDireccionActualCliente(rs.getString("direccióna_persona"));
		cliente.setReferenciaDireccionCliente(rs.getString("referencia_persona"));
		cliente.setFacebookCliente(rs.getString("facebook_cliente"));
		cliente.setCorreoCliente(rs.getString("correo_cliente"));
		cliente.setEstadoCliente(rs.getBoolean("activo_cliente"));
		return cliente;
	}
}
