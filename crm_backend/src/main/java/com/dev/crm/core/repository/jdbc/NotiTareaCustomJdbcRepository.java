package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.ObtenernumerotareaRequest;
import com.dev.crm.core.util.Constantes;

@Repository("NotiTareaJdbcRepository")
public class NotiTareaCustomJdbcRepository implements NotiTareaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String spObtenercantidadtarea(ObtenernumerotareaRequest cantidad) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CANTIDAD_TAREA);
			simpleJdbcCall.declareParameters(
					new SqlParameter("CODUSU", Types.VARCHAR),
					new SqlOutParameter("CANTIDAD", Types.LONGVARCHAR));
			
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODUSU", cantidad.getDatovaluar());
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			String result = (String) out.get("CANTIDAD");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
