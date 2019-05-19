package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.DetalleHerramientaViewModel;

public class DetalleHerramientaResultViewModelMapper implements RowMapper<DetalleHerramientaViewModel> {

	@Override
	public DetalleHerramientaViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DetalleHerramientaViewModel DetallHerResultViewModel = new DetalleHerramientaViewModel();
		DetallHerResultViewModel.setCodigodetalle(rs.getInt("codi_dether"));
		DetallHerResultViewModel.setCogidoherramienta(rs.getInt("codi_herra"));
		DetallHerResultViewModel.setPregunta(rs.getString("pregunta"));
		DetallHerResultViewModel.setSecuencial(rs.getInt("sec_herra"));
		return DetallHerResultViewModel;
	}

}
