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

import com.dev.crm.core.dto.ActivacionesResultViewModel;
import com.dev.crm.core.mapper.ActivacionesResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("activacionesJdbcRepository")
public class ActivacionesCustomJdbcRepository implements ActivacionesJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivacionesResultViewModel> listarActivacionesInstalacion() {
		
		List<ActivacionesResultViewModel> activacionesInstalacion = new ArrayList<ActivacionesResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_REPORTE_ACTIVACIONES)
							.returningResultSet("activacionesInstalacion", new ActivacionesResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			activacionesInstalacion = (List<ActivacionesResultViewModel>) result.get("activacionesInstalacion");
			return activacionesInstalacion;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
