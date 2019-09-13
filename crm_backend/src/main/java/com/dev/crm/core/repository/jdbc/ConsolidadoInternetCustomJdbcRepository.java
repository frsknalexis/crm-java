package com.dev.crm.core.repository.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.ConsolidadoInternetResultViewModel;
import com.dev.crm.core.mapper.ConsolidadoInternetResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("consolidadoInternetJdbcRepository")
public class ConsolidadoInternetCustomJdbcRepository implements ConsolidadoInternetJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ConsolidadoInternetResultViewModel> listarConsolidadoInternet() {
		
		List<ConsolidadoInternetResultViewModel> listaConsolidadoInternet = new ArrayList<ConsolidadoInternetResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CONSOLIDADO_INTERNET)
					.returningResultSet("listaConsolidadoInternet", new ConsolidadoInternetResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			listaConsolidadoInternet = (List<ConsolidadoInternetResultViewModel>) result.get("listaConsolidadoInternet");
			return listaConsolidadoInternet;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
