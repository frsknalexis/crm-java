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

import com.dev.crm.core.dto.CuentasPorInstalarResultViewModel;
import com.dev.crm.core.mapper.CuentasPorInstalarResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("cuentasPorInstalarJdbcRepository")
public class CuentasPorInstalarCustomJdbcRepository implements CuentasPorInstalarJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CuentasPorInstalarResultViewModel> listarCuentaPorInstalar() {
		
		List<CuentasPorInstalarResultViewModel> cuentasPorInstalar = new ArrayList<CuentasPorInstalarResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_CUENTA_POR_INSTALAR);
			simpleJdbcCall.returningResultSet("cuentasPorInstalar", new CuentasPorInstalarResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			cuentasPorInstalar = (List<CuentasPorInstalarResultViewModel>) result.get("cuentasPorInstalar");
			return cuentasPorInstalar;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
