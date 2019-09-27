package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.util.Constantes;

@Repository("activacionesMesCableJdbcRepository")
public class ActivacionesMesCableCustomJdbcRepository implements ActivacionesMesCableJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public Integer contadorActivadoMesCable() {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_CONTADOR_ACTIVADO_MES_CABLE)
						.declareParameters(new SqlOutParameter("CANTIDAD", Types.INTEGER));
			
			Map<String, Object> out = simpleJdbcCall.execute(new HashMap<String, Object>(0));
			Integer result = (Integer) out.get("CANTIDAD");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
