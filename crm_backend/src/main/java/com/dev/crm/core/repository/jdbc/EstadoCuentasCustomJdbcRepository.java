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

import com.dev.crm.core.dto.EstadoCuentasResultViewModel;
import com.dev.crm.core.mapper.EstadoCuentasResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("estadoCuentasJdbcRepository")
public class EstadoCuentasCustomJdbcRepository implements EstadoCuentasJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoCuentasResultViewModel> listarEstadoCuentas() {
		
		List<EstadoCuentasResultViewModel> estadoCuentas = new ArrayList<EstadoCuentasResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_ESTADO_CUENTA);
			simpleJdbcCall.returningResultSet("estadoCuentas", new EstadoCuentasResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			estadoCuentas = (List<EstadoCuentasResultViewModel>) result.get("estadoCuentas");
			return estadoCuentas;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
