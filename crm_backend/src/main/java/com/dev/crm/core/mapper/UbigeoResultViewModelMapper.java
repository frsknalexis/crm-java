package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.UbigeoResultViewModel;

public class UbigeoResultViewModelMapper implements RowMapper<UbigeoResultViewModel> {

	@Override
	public UbigeoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UbigeoResultViewModel listaUbigeo = new UbigeoResultViewModel();
		listaUbigeo.setCodigoUbigeo(rs.getString("codigo_ubigeo"));
		listaUbigeo.setNombreUbigeo(rs.getString("nombre_ubigeo"));
		return listaUbigeo;
	}
}
