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

import com.dev.crm.core.dto.CorteInternetResultViewModel;
import com.dev.crm.core.mapper.CorteInternetResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("corteInternetJdbcRepository")
public class CorteInternetCustomJdbcRepository implements CorteInternetJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public CorteInternetCustomJdbcRepository(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CorteInternetResultViewModel> spListarCorte() {
		
		List<CorteInternetResultViewModel> cortesInternet = new ArrayList<CorteInternetResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CORTE_INTERNET)
				.returningResultSet("cortesInternet", new CorteInternetResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			cortesInternet = (List<CorteInternetResultViewModel>) result.get("cortesInternet");
			return cortesInternet;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
