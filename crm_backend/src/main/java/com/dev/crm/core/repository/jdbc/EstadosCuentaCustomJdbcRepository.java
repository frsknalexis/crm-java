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

import com.dev.crm.core.dto.EstadosCuentaResultViewModel;
import com.dev.crm.core.mapper.EstadosCuentaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("estadosCuentaJdbcRepository")
public class EstadosCuentaCustomJdbcRepository implements EstadosCuentaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EstadosCuentaResultViewModel> listarEstadosCuentas() {
		
		List<EstadosCuentaResultViewModel> estadosCuentas = new ArrayList<EstadosCuentaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_ESTADO);
			simpleJdbcCall.returningResultSet("estadosCuentas", new EstadosCuentaResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			estadosCuentas = (List<EstadosCuentaResultViewModel>) result.get("estadosCuentas");
			return estadosCuentas;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
