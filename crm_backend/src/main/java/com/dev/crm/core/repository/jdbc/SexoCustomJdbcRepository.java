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

import com.dev.crm.core.dto.SexoResultViewModel;
import com.dev.crm.core.mapper.SexoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("sexoJdbcRepository")
public class SexoCustomJdbcRepository implements SexoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SexoResultViewModel> listarSexo() {
		
		List<SexoResultViewModel> listaSexo = new ArrayList<SexoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_SEXO)
							.returningResultSet("listaSexo", new SexoResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			listaSexo = (List<SexoResultViewModel>) result.get("listaSexo");
			return listaSexo;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
