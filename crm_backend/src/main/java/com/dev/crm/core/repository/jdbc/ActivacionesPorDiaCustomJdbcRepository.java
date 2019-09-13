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

import com.dev.crm.core.dto.ActivacionesPorDiaRequest;
import com.dev.crm.core.dto.ActivacionesPorDiaResultViewModel;
import com.dev.crm.core.mapper.ActivacionesPorDiaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("activacionesPorDiaJdbcRepository")
public class ActivacionesPorDiaCustomJdbcRepository implements ActivacionesPorDiaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivacionesPorDiaResultViewModel> listarActivacionesPorDia(ActivacionesPorDiaRequest request) {
		
		List<ActivacionesPorDiaResultViewModel> activacionesPorDia = new ArrayList<ActivacionesPorDiaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_ACTIVACIONES_POR_DIA)
						.declareParameters(new SqlParameter("fechai", Types.DATE))
						.returningResultSet("activacionesPorDia", new ActivacionesPorDiaResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("fechai", request.getFechaBusqueda());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			activacionesPorDia = (List<ActivacionesPorDiaResultViewModel>) result.get("activacionesPorDia");
			return activacionesPorDia;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
