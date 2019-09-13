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

import com.dev.crm.core.dto.UbigeoResultViewModel;
import com.dev.crm.core.mapper.UbigeoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("ubigeoJdbcRepository")
public class UbigeoCustomJdbcRepository implements UbigeoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UbigeoResultViewModel> listarUbigeo() {
		
		List<UbigeoResultViewModel> listaUbigeo = new ArrayList<UbigeoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_UBIGEO)
					.returningResultSet("listaUbigeo", new UbigeoResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			listaUbigeo = (List<UbigeoResultViewModel>) result.get("listaUbigeo");
			return listaUbigeo;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
