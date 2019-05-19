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

import com.dev.crm.core.dto.ReclamoResultViewModel;
import com.dev.crm.core.mapper.ViewReclamoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("ViewReclamoJdbcRepository")
public class ViewReclamoCustomJdbcRepository implements ViewReclamoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReclamoResultViewModel> spListaReclamo(String usuario) {

		List<ReclamoResultViewModel> reclamo = new ArrayList<ReclamoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_RECLAMO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODUSU", Types.VARCHAR));
			
			simpleJdbcCall.returningResultSet("reclamo", new ViewReclamoResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODUSU", usuario);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			reclamo = (List<ReclamoResultViewModel>) result.get("reclamo");
			return reclamo;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
