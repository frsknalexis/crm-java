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

import com.dev.crm.core.dto.InstalacionesResultViewModel;
import com.dev.crm.core.mapper.InstalacionesResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("instalacionesJdbcRepository")
public class InstalacionesCustomJdbcRepository implements InstalacionesJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InstalacionesResultViewModel> contadorInstalacionesRealizadas() {
		
		List<InstalacionesResultViewModel> instalacionesRealizadas = new ArrayList<InstalacionesResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CONTADOR_INSTALACIONES_REALIZADAS)
							.returningResultSet("instalacionesRealizadas", new InstalacionesResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			instalacionesRealizadas = (List<InstalacionesResultViewModel>) result.get("instalacionesRealizadas");
			return instalacionesRealizadas;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
