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

import com.dev.crm.core.dto.EmpleadoResultViewModel;
import com.dev.crm.core.mapper.EmpleadoResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("empleadoJdbcRepository")
public class EmpleadoCustomRepository implements EmpleadoJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmpleadoResultViewModel> spListarEmpleadosIntExt() {
		
		List<EmpleadoResultViewModel> empleados = new ArrayList<EmpleadoResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_EMPLEADOS_INT_EXT)
				.returningResultSet("empleados", new EmpleadoResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			empleados = (List<EmpleadoResultViewModel>) result.get("empleados");
			return empleados;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
