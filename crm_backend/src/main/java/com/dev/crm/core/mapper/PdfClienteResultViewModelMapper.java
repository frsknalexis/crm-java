package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PdfClienteResultViewModel;

public class PdfClienteResultViewModelMapper implements RowMapper<PdfClienteResultViewModel> {

	@Override
	public PdfClienteResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PdfClienteResultViewModel pdfCliente = new PdfClienteResultViewModel();
		pdfCliente.setDocumentoPersonaCliente(rs.getString("documento_persona"));
		pdfCliente.setCliente(rs.getString("cliente"));
		pdfCliente.setDireccionCliente(rs.getString("direccióna_persona"));
		pdfCliente.setCodigoCliente(rs.getString("codigo_cliente"));
		pdfCliente.setCorreoCliente(rs.getString("correo_cliente"));
		pdfCliente.setFacebookCliente(rs.getString("facebook_cliente"));
		pdfCliente.setEstadoCliente(rs.getString("estado_cliente"));
		return pdfCliente;
	}

}
