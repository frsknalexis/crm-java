package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.ActivacionesPorRangoRequest;
import com.dev.crm.core.dto.ActivacionesPorRangoResultViewModel;
import com.dev.crm.core.mapper.ActivacionesPorRangoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("activacionesPorRangoJdbcRepository")
public class ActivacionesPorRangoCustomJdbcRepository implements ActivacionesPorRangoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivacionesPorRangoResultViewModel> listarActivacionesPorRango(ActivacionesPorRangoRequest request) {
		
		List<ActivacionesPorRangoResultViewModel> activacionesPorRango = new ArrayList<ActivacionesPorRangoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_ACTIVACIONES_POR_RANGO)
					.declareParameters(new SqlParameter("fechai", Types.DATE),
							new SqlParameter("fechaf", Types.DATE))
					.returningResultSet("activacionesPorRango", new ActivacionesPorRangoResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("fechai", request.getFechaInicial());
			inParams.addValue("fechaf", request.getFechaFinal());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			activacionesPorRango = (List<ActivacionesPorRangoResultViewModel>) result.get("activacionesPorRango");
			return activacionesPorRango;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
