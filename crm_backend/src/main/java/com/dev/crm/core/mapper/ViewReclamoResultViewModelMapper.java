package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ReclamoResultViewModel;

public class ViewReclamoResultViewModelMapper implements RowMapper<ReclamoResultViewModel> {

	@Override
	public ReclamoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ReclamoResultViewModel clienteAtencion = new ReclamoResultViewModel();
		clienteAtencion.setCodigoreclamo(rs.getString("codi_recl"));
		clienteAtencion.setNombrecliente(rs.getString("CLIENTE"));
		clienteAtencion.setDireccioncliente(rs.getString("direccióna_persona"));
		clienteAtencion.setDescripcionreclamo(rs.getString("descripcion_reclamo"));
		clienteAtencion.setFechareclamo(rs.getDate("fechar_reclamo"));
		clienteAtencion.setHora(rs.getString("horar_reclamo"));
		return clienteAtencion;
	}

}
