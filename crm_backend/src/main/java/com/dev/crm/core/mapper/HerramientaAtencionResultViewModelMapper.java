package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.HerramientaResultViewModel;

public class HerramientaAtencionResultViewModelMapper implements RowMapper<HerramientaResultViewModel> {

	@Override
	public HerramientaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		HerramientaResultViewModel herramientaAtencion = new HerramientaResultViewModel();
		herramientaAtencion.setDescripcionherramienta(rs.getString("descripcion_herra"));
		herramientaAtencion.setHerramienta(rs.getString("codi_herra"));
		herramientaAtencion.setDescripciontipoherramienta(rs.getString("descripcion_tipherr"));
		herramientaAtencion.setValor(rs.getString("VALOR"));
		herramientaAtencion.setFechafinal(rs.getString("fechaf_herra"));
		herramientaAtencion.setFechainicio(rs.getString("fechai_herra"));
		return herramientaAtencion;
	}

}
