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

import com.dev.crm.core.dto.EmpleadoEXTINTResultViewModel;
import com.dev.crm.core.mapper.EmpleadoIntExtResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("EmpleadointextJdbcRepository")
public class EmpleadoIntextCustomJdbcRepository implements EmpleadointextJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmpleadoEXTINTResultViewModel> spListarEmpleadoDetalleGeneral() {
		
		List<EmpleadoEXTINTResultViewModel> datosempleago = new ArrayList<EmpleadoEXTINTResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_EMPLEADO_GENERAL_EXT_INT)
					.returningResultSet("datosempleago", new EmpleadoIntExtResultViewModelMapper());
			
			Map<String, Object> result = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			datosempleago = (List<EmpleadoEXTINTResultViewModel>) result.get("datosempleago");
			return datosempleago;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
