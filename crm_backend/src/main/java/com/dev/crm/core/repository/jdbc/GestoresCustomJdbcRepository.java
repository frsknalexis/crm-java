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

import com.dev.crm.core.dto.GestoresResultViewModel;
import com.dev.crm.core.mapper.GestoresResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("gestoresJdbcRepository")
public class GestoresCustomJdbcRepository implements GestoresJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GestoresResultViewModel> listarGestores() {
		
		List<GestoresResultViewModel> gestores = new ArrayList<GestoresResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTA_GESTORES);
			simpleJdbcCall.returningResultSet("gestores", new GestoresResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			gestores = (List<GestoresResultViewModel>) result.get("gestores");
			return gestores;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
