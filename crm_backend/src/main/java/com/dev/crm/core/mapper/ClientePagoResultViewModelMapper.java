package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ClientePagoResultViewModel;

public class ClientePagoResultViewModelMapper implements RowMapper<ClientePagoResultViewModel> {

	@Override
	public ClientePagoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClientePagoResultViewModel clientePagoResultViewModel = new ClientePagoResultViewModel();
		clientePagoResultViewModel.setDocumentoPersonaCliente(rs.getString("documento_personac"));
		clientePagoResultViewModel.setNombreComercialCliente(rs.getString("nombrecom_cliente"));
		clientePagoResultViewModel.setCliente(rs.getString("cliente"));
		clientePagoResultViewModel.setDireccionActualCliente(rs.getString("direccióna_persona"));
		clientePagoResultViewModel.setReferencia(rs.getString("referencia_persona"));
		return clientePagoResultViewModel;
	}

}
