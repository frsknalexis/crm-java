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

import com.dev.crm.core.dto.DeudasGestoresResultViewModel;
import com.dev.crm.core.dto.DiasDeudasRequest;
import com.dev.crm.core.mapper.DeudasGestoresResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("deudasGestoresJdbcRepository")
public class DeudasGestoresCustomJdbcRepository implements DeudasGestoresJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeudasGestoresResultViewModel> recuperarDiasDeudasGestoresParametrizado(DiasDeudasRequest request) {
		
		List<DeudasGestoresResultViewModel> deudasGestores = new ArrayList<DeudasGestoresResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.RECUPERAR_DIAS_DEUDAS_PARAMETRIZADO);
			simpleJdbcCall.declareParameters(new SqlParameter("TEXTO", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("deudasGestores", new DeudasGestoresResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("TEXTO", request.getDiasDeudas());
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			deudasGestores = (List<DeudasGestoresResultViewModel>) result.get("deudasGestores");
			return deudasGestores;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
