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

import com.dev.crm.core.dto.DiasDeudasResultViewModel;
import com.dev.crm.core.mapper.DiasDeudasResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("diasDeudasJdbcRepository")
public class DiasDeudasCustomJdbcRepository implements DiasDeudasJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DiasDeudasResultViewModel> recuperarDiasDeudas() {
		
		List<DiasDeudasResultViewModel> diasDeudas = new ArrayList<DiasDeudasResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.RECUPERAR_DIAS_DEUDAS);
			simpleJdbcCall.returningResultSet("diasDeudas", new DiasDeudasResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			diasDeudas = (List<DiasDeudasResultViewModel>) result.get("diasDeudas");
			return diasDeudas;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
